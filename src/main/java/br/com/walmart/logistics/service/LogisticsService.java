/**
 * 
 */
package br.com.walmart.logistics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.walmart.logistics.controller.request.LogisticMapRequest;
import br.com.walmart.logistics.controller.response.LogisticMapResponse;
import br.com.walmart.logistics.core.entity.LogisticMap;
import br.com.walmart.logistics.core.repository.LogisticsRepository;
import br.com.walmart.logistics.parse.LogisticMapParse;

/**
 * @author Denis soares moreira
 * 
 */
@Service
public class LogisticsService {

	@Autowired
	private LogisticsRepository logisticsRepository;
	
	
	public LogisticMapResponse calculateLowerCostRoute(String destinationPoint,
			String pointOrigin, Double autonomy, Double value) {
		
		
		
		
		
				return null;
		
	}

	/**
	 * Sava uma coleção de RoutesMaps e aplica o parse para retornar o pojo correto de acordo com seu papel
	 * @param listLogisticMapRequests {@link List<LogisticMapRequest.class>}
	 * @return {@link List<LogisticMapResponse.class>}
	 */
	public List<LogisticMapResponse> saveListRoutesMaps(List<LogisticMapRequest> listLogisticMapRequests) {

		List<LogisticMapResponse> listResponse = new ArrayList<>();
		
		listLogisticMapRequests.forEach((LogisticMapRequest request) -> {
			LogisticMap entity = LogisticMapParse.logisticRequestToLogisticEntity(request);
			LogisticMap saved = logisticsRepository.save(entity);
			listResponse.add(LogisticMapParse.logisticEntityToLogisticResponse(saved));
		});
		
		return listResponse;
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