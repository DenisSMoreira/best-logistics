/**
 * 
 */
package br.com.walmart.logistics.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.walmart.logistics.controller.request.LogisticMapRequest;
import br.com.walmart.logistics.controller.request.RouteMapRequest;
import br.com.walmart.logistics.controller.response.LogisticMapResponse;
import br.com.walmart.logistics.core.entity.LogisticMap;
import br.com.walmart.logistics.core.entity.RouteMap;
import br.com.walmart.logistics.core.repository.LogisticsRepository;

/**
 * Classe de testes usando JUnit e Mockito 
 * @author Denis soares moreira
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class LogisticsServiceTest {

	@InjectMocks
	private LogisticsService logisticsService = new LogisticsService();
	
	@Mock
	private LogisticsRepository logisticsRepository;
	
	@Before
	public void setUp() {
		logisticsService.setLogisticsRepository(logisticsRepository);
	}
	
	@Test
	public void calculateLowerCostRoute(){
		
		Double autonomy = 10d;
		Double value = 2.5;
		String destinationPoint = "Rio Claro";
		String pointOrigin = "Campinas";
		
		LogisticMapResponse mapResponse = logisticsService.calculateLowerCostRoute(
																destinationPoint, 
																pointOrigin, 
																autonomy, 
																value
														    );
		assertNotNull(mapResponse.getRouteMap());
	}
	
	@Test
	public void saveListRoutesMaps(){
		List<LogisticMapRequest> listLogisticMapRequests = Arrays.asList(populateLogisticMapRequest());
		
		LogisticMap mapEntity = populateLogisticMapEntity();
		Mockito.when(logisticsRepository.save(mapEntity)).thenReturn(mapEntity);
		
		List<LogisticMapResponse> listSavedRoutesMaps = logisticsService.saveListRoutesMaps(listLogisticMapRequests);
		
		assertNotNull(listSavedRoutesMaps);
		assertFalse(listSavedRoutesMaps.isEmpty());
	}
	
	@Test
	public void saveRouteMap(){
		LogisticMap mapEntity = populateLogisticMapEntity();
		Mockito.when(logisticsRepository.save(mapEntity)).thenReturn(mapEntity);
		
		LogisticMapRequest mapRequest = populateLogisticMapRequest();
		LogisticMapResponse savedRouteMap = logisticsService.saveRouteMap(mapRequest);
		
		assertNotNull(savedRouteMap);
		assertEquals(mapEntity.getName(), savedRouteMap.getName());
	}
	
	@Test
	public void findLogisticMapByName(){
		
		LogisticMap logisticMap = populateLogisticMapEntity();
		Mockito.when(logisticsRepository.findByName(Mockito.anyString())).thenReturn(logisticMap);
		
		String name = "Trabalho";
		LogisticMapResponse logisticMapResponse = logisticsService.findLogisticMapByName(name);
		
		assertNotNull(logisticMapResponse);
		assertEquals(name, logisticMapResponse.getName());
	}

	@Test
	public void findAllRoutesMaps(){
		List<LogisticMap> logisticMap = Arrays.asList(populateLogisticMapEntity());
		Mockito.when(logisticsRepository.findAll()).thenReturn(logisticMap);
		
		List<LogisticMapResponse> listResponse = logisticsService.findAllRoutesMaps();
		
		assertNotNull(listResponse);
		assertFalse(listResponse.isEmpty());
	}

	private LogisticMap populateLogisticMapEntity() {
		LogisticMap logisticMap = new LogisticMap();
		logisticMap.setId("QRQWqQWEQWE3413");
		logisticMap.setName("Trabalho");
		List<RouteMap> routeMap = new ArrayList<>();
		RouteMap map = new RouteMap();
		map.setPointOrigin("Campinas");;
		map.setDestinationPoint("Rio Claro");
		map.setDistancePoints(10d);
		routeMap.add(map);
		logisticMap.setRouteMap(routeMap );
		return logisticMap;
	}
 
	private LogisticMapRequest populateLogisticMapRequest() {
		LogisticMapRequest logisticMap = new LogisticMapRequest();
		logisticMap.setName("Trabalho");
		List<RouteMapRequest> routeMap = new ArrayList<>();
		RouteMapRequest map = new RouteMapRequest();
		map.setPointOrigin("Campinas");;
		map.setDestinationPoint("Rio Claro");
		map.setDistancePoints("10");
		routeMap.add(map);
		logisticMap.setRouteMap(routeMap );
		return logisticMap;
	}
	
}