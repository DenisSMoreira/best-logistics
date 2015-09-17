package br.com.best.logistics.parse;

import java.util.ArrayList;
import java.util.List;

import br.com.best.logistics.controller.request.LogisticMapRequest;
import br.com.best.logistics.controller.request.RouteMapRequest;
import br.com.best.logistics.controller.response.LogisticMapResponse;
import br.com.best.logistics.controller.response.RouteMapResponse;
import br.com.best.logistics.core.entity.LogisticMap;
import br.com.best.logistics.core.entity.RouteMap;

/**
 * Parse de entrada e saida da aplicação, parse nescessário caso exista futuros tratamento especificos para entrada e saida
 * @author Denis soares moreira
 *
 */
public class LogisticMapParse {

	/**
	 * Parse entidade para pojo de response
	 * @param logisticMap {@link LogisticMap.class}
	 * @return {@link LogisticMapResponse.class}
	 */
	public static final LogisticMapResponse logisticEntityToLogisticResponse(LogisticMap logisticMap) {
		final LogisticMapResponse logisticMapResponse = new LogisticMapResponse();
		logisticMapResponse.setName(logisticMap.getName());
		logisticMapResponse.setId(logisticMap.getId());
		final List<RouteMapResponse> routeMapResponse = new ArrayList<>();
		
		logisticMap.getListRoutesMaps().forEach( (RouteMap map) -> {
			final RouteMapResponse mapResponse = new RouteMapResponse() ;
			mapResponse.setPointOrigin(map.getPointOrigin());
			mapResponse.setDestinationPoint(map.getDestinationPoint());
			mapResponse.setDistancePoints(map.getDistancePoints().toString());
			routeMapResponse.add(mapResponse);
		});
		
		logisticMapResponse.setListRoutesMaps(routeMapResponse );
		return logisticMapResponse;
	}
	
	
	/**
	 * Parse do pojo de requisão para entidade
	 * @param logisticMapRequest {@link LogisticMapRequest}
	 * @return {@link LogisticMap}
	 */
	public static final LogisticMap logisticRequestToLogisticEntity(LogisticMapRequest logisticMapRequest) {
		final LogisticMap logisticMapEntity = new LogisticMap();
		logisticMapEntity.setName(logisticMapRequest.getName());
		
		final List<RouteMap> routeMapResponse = new ArrayList<>();
		
		logisticMapRequest.getListRoutesMaps().forEach( (RouteMapRequest map) -> {
			RouteMap mapEntity = new RouteMap() ;
			mapEntity.setPointOrigin(map.getPointOrigin());
			mapEntity.setDestinationPoint(map.getDestinationPoint());
			mapEntity.setDistancePoints(Double.parseDouble(map.getDistancePoints()));
			routeMapResponse.add(mapEntity);
		});
		
		logisticMapEntity.setListRoutesMaps(routeMapResponse );
		return logisticMapEntity;
	}
}
