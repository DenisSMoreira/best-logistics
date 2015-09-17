/**
 * 
 */
package br.com.best.logistics.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;

import br.com.best.logistics.controller.request.LogisticMapRequest;
import br.com.best.logistics.controller.response.LogisticMapResponse;
import br.com.best.logistics.controller.response.TravelLowerCostResponse;
import br.com.best.logistics.core.entity.LogisticMap;
import br.com.best.logistics.core.entity.RouteMap;
import br.com.best.logistics.core.repository.LogisticsRepository;
import br.com.best.logistics.parse.LogisticMapParse;

/**
 * Serviço responsavel por controlar a logistica das rotas
 *
 * @author Denis soares moreira
 */
@Service
public class LogisticsService {

	private static final double KM_START = 0.0;
	private static final int UNI_RESULT = 1;
	private static final int INIT = 0;
	
	@Autowired
	private LogisticsRepository logisticsRepository;
	
	/**
	 * Calcula a melhor rota de acordo com as informação enviadas
	 * @param nameMap {@link String}
	 * @param pointOrigin {@link String}
	 * @param destinationPoint {@link String}
	 * @param autonomy {@link Double}
	 * @param value {@link Double}
	 * @return {@link TransactionException}
	 * @throws Exception
	 */
	public TravelLowerCostResponse calculateLowerCostRoute(String nameMap,
			String pointOrigin, String destinationPoint, Double autonomy, Double value) throws Exception {
		
		LogisticMap mapsPointOrigin = logisticsRepository.findByName(nameMap);
		
		List<RouteMap> listRoutesDestionFinalfound = new ArrayList<>();
		List<RouteMap> listNeighbors = new ArrayList<>();
		List<RouteMap> listRoutesMaps = mapsPointOrigin.getListRoutesMaps();
		List<RouteMap> listBestWay = new ArrayList<>();
		
		//Descobre o nó de ponto de origem para começar a verificação
		discoverOriginPointNode(pointOrigin, destinationPoint, listRoutesDestionFinalfound,
				listNeighbors, listRoutesMaps);


		//Caso o ponto de origem e destino estejam na mesma rota e se houver mais de um caso igual, ele retorna o menor em distancia 
		//Ex: A ~ B = 10 && A ~ B = 5, ele irá retornar a rota com distancia 5
		if(!listRoutesDestionFinalfound.isEmpty()){
			return getRouteFoundResponse(autonomy, value, mapsPointOrigin, listRoutesDestionFinalfound);
		}

		//Analise de rota
		Double kmTotal = analyzeBestRoute(destinationPoint, listNeighbors, listRoutesMaps,
				listBestWay);
		
		mapsPointOrigin.setListRoutesMaps(listBestWay);
		
		TravelLowerCostResponse travel = getTravelLowerCostResponse(
											autonomy, 
											value,
											mapsPointOrigin,
											kmTotal
										 );
		
		return travel;
		
	}


	/**
	 * Analisa a melhor rota desde que aja ligação de origem e retorno 
	 * @param destinationPoint {@link String}
	 * @param listNeighbors List<RouteMap>
	 * @param listRoutesMaps List<RouteMap>
	 * @param listBestWay List<RouteMap>
	 * @throws Exception
	 * @return kmTotal {@link Double} 
	 */
	protected Double analyzeBestRoute(String destinationPoint,
			List<RouteMap> listNeighbors, List<RouteMap> listRoutesMaps,
			List<RouteMap> listBestWay) throws Exception {
		
		Double kmTotal = KM_START;
		
		while(!listRoutesMaps.isEmpty()){
								
			RouteMap menorAdjacente = getMinorRouteMap(listNeighbors);
			kmTotal += menorAdjacente.getDistancePoints();
			listNeighbors.clear();
			listBestWay.add(menorAdjacente);
			listRoutesMaps.remove(menorAdjacente);
			
			//For each normal para que se tenha a opção de usar o break.
			for (RouteMap routeMap : listRoutesMaps) {
				
				if(routeMap.getPointOrigin().equals(menorAdjacente.getDestinationPoint())){
					
					listNeighbors.add(routeMap);
				} else {
					if(menorAdjacente.getDestinationPoint().equals(destinationPoint) || destinationPoint.equals(menorAdjacente.getPointOrigin())){
						listRoutesMaps.clear();
						break;
					}
				}
			}
			
			if(listNeighbors.isEmpty() && !listRoutesMaps.isEmpty()){
				throw new Exception("Não há rota de destino do caminho: "+ listBestWay.get(listBestWay.size()).getDestinationPoint()+ " para o trajeto final: "+ destinationPoint);
			}
			
		}
		return kmTotal;
	}


	/**
	 * Descobre o nó original para começar a analise de rota e salva a referencia da mesma
	 * @param pointOrigin {@link String} 
	 * @param destinationPoint {@link String}
	 * @param listRoutesDestionFinalfound List<RouteMap> listRoutesDestionFinalfound 
	 * @param listNeighbors List<RouteMap> listNeighbors
	 * @param listRoutesMaps List<RouteMap> listRoutesMaps
	 */
	protected void discoverOriginPointNode(String pointOrigin, String destinationPoint,
			List<RouteMap> listRoutesDestionFinalfound,
			List<RouteMap> listNeighbors, List<RouteMap> listRoutesMaps) {
		
		listRoutesMaps.forEach((RouteMap routeMap) -> {
			if(pointOrigin.equals(routeMap.getPointOrigin())){
				if(destinationPoint.equals(routeMap.getDestinationPoint())){
					listRoutesDestionFinalfound.add(routeMap);
				} else {
					listNeighbors.add(routeMap);
				}
			}
		});
	}


	/**
	 * Retorna a saida esperada com o pojo enriquecido sem as informações de analise, porque a rota possui o mesmo trecho final
	 * @param mapsPointOrigin {@link String}
	 * @param autonomy {@link Double}
	 * @param value {@link Double}
	 * @param routefound {List<RouteMap>.class}
	 * @return {@link TravelLowerCostResponse}
	 */
	protected TravelLowerCostResponse getRouteFoundResponse(Double autonomy, Double value,
			LogisticMap mapsPointOrigin, List<RouteMap> routefound) {
		
		if(routefound.size() == UNI_RESULT){
			mapsPointOrigin.setListRoutesMaps(routefound);
			TravelLowerCostResponse travel = getTravelLowerCostResponse(
					autonomy, 
					value,
					mapsPointOrigin,
					routefound.get(INIT).getDistancePoints()
				 );

			return travel;
			
		} else {

			RouteMap routeMapMinorDistance = getMinorRouteMap(routefound);
			mapsPointOrigin.setListRoutesMaps(Arrays.asList(routeMapMinorDistance));
			TravelLowerCostResponse travel = getTravelLowerCostResponse(
					autonomy, 
					value,
					mapsPointOrigin,
					routeMapMinorDistance.getDistancePoints()
					);
			
			return travel;
		}
	}


	/**
	 * Retorna a saida esperada com o pojo enriquecido com as informações de analise
	 * @param autonomy {@link Double}
	 * @param value {@link Double}
	 * @param mapsPointOrigin {@link String}
	 * @param kmTotal {@link Double}
	 * @return {@link TravelLowerCostResponse}
	 */
	protected TravelLowerCostResponse getTravelLowerCostResponse(Double autonomy, Double value,
			LogisticMap mapsPointOrigin, Double kmTotal) {
		TravelLowerCostResponse travel = new TravelLowerCostResponse();
		travel.setAutonomy(autonomy.toString());
		travel.setValueFuel(value.toString());
		travel.setCostTotal(calculateCostTotal(autonomy, value, kmTotal));
		travel.setLogisticMapResponse(LogisticMapParse.logisticEntityToLogisticResponse(mapsPointOrigin));
		return travel;
	}


	/**
	 * Calcula o custo total da viagem 
	 * @param autonomy {@link Double}
	 * @param value {@link Double}
	 * @param kmTotal {@link Double}
	 * @return costTotal {@link String}
	 */ 
	protected String calculateCostTotal(Double autonomy, Double value, Double kmTotal) {
		Double costTotal = (kmTotal / autonomy) * value;
		return costTotal.toString();
	}

	
	/**
	 * Retorna a rota com menor distancia
	 * @param routefound
	 * @return
	 */
	public RouteMap getMinorRouteMap(List<RouteMap> routefound) {
		
		Optional<RouteMap> findFirst = routefound.stream().sorted(
											 Comparator.comparing(RouteMap::getDistancePoints)
											).findFirst();

		return findFirst.get();
	}

	/**
	 * Salva a RouteMap e aplica um parse para retornar o pojo correto de acordo com seu papel
	 *  na aplicação 
	 * @param mapRequest {@link LogisticMapRequest.class}
	 * @return {@link LogisticMapResponse.class}
	 */
	public LogisticMapResponse saveRouteMap(LogisticMapRequest mapRequest) {
		LogisticMap entity = LogisticMapParse.logisticRequestToLogisticEntity(mapRequest);
		LogisticMap saved = logisticsRepository.save(entity);
		
		return LogisticMapParse.logisticEntityToLogisticResponse(saved);
	}

	/**
	 * Procura a LogisticMap por nome e aplica o parse para retornar o pojo de response
	 * @param name {@link String}
	 * @return {@link LogisticMapResponse}
	 */
	public LogisticMapResponse findLogisticMapByName(String name) {
		
		LogisticMap logisticMap = logisticsRepository.findByName(name);
		LogisticMapResponse logisticMapResponse = LogisticMapParse.logisticEntityToLogisticResponse(logisticMap);
		
		return logisticMapResponse;
	}

	
	/**
	 * Procura todas as RoutesMaps já salvas
	 * @return {@link List<LogisticMapResponse.class>}
	 */
	public List<LogisticMapResponse> findAllRoutesMaps() {
		List<LogisticMap> listLogisticMap = logisticsRepository.findAll();
		List<LogisticMapResponse> listResponse = new ArrayList<>();
		
		listLogisticMap.forEach( (LogisticMap map) -> {
			listResponse.add(LogisticMapParse.logisticEntityToLogisticResponse(map));
		});
		
		return listResponse;
	}

	/**
	 * Utilização nescessária para testes com mockito
	 * @param logisticsRepository {@link LogisticsRepository.class}
	 */
	protected void setLogisticsRepository(LogisticsRepository logisticsRepository) {
		this.logisticsRepository = logisticsRepository;
	}


 
}