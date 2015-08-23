/**
 * 
 */
package br.com.walmart.logistics.service;

import static org.junit.Assert.*;

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
import br.com.walmart.logistics.controller.response.TravelLowerCostResponse;
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
	public void calculateLowerCostRoute() throws Exception{
		LogisticMap logisticMap = populateLogisticMapEntity();
		logisticMap.setListRoutesMaps(pupulateRoutesMaps());
		Mockito.when(logisticsRepository.findByName(Mockito.anyString())).thenReturn(logisticMap);
		
		
		Double autonomy = 10d;
		Double value = 2.5;
		String destinationPoint = "F";
		String pointOrigin = "A";
		String nameMap = "SP";

		TravelLowerCostResponse travelLowerCostResponse = logisticsService.calculateLowerCostRoute(
																nameMap, 
																pointOrigin, 
																destinationPoint, 
																autonomy, value
														    );
		assertNotNull(travelLowerCostResponse);
		assertEquals(travelLowerCostResponse.getCostTotal(), "6.5");
	}
	
	@Test
	public void caculateMinorDistance(){
		List<RouteMap> routefound = pupulateRoutesMaps();
		
		logisticsService.getMinorRouteMap(routefound );
	}

	private List<RouteMap> pupulateRoutesMaps() {
		List<RouteMap> routefound = new ArrayList<RouteMap>();
		RouteMap routeMap = new RouteMap();
		routeMap.setDistancePoints(10d);
		routeMap.setPointOrigin("A");
		routeMap.setDestinationPoint("B");
		
		RouteMap routeMap2 = new RouteMap();
		routeMap2.setDistancePoints(13d);
		routeMap2.setPointOrigin("A");
		routeMap2.setDestinationPoint("C");
		
		RouteMap routeMap3 = new RouteMap();
		routeMap3.setDistancePoints(5d);
		routeMap3.setPointOrigin("C");
		routeMap3.setDestinationPoint("D");
		
		RouteMap routeMap4 = new RouteMap();
		routeMap4.setDistancePoints(10d);
		routeMap4.setPointOrigin("D");
		routeMap4.setDestinationPoint("F");
		
		RouteMap routeMap5 = new RouteMap();
		routeMap5.setDistancePoints(8d);
		routeMap5.setPointOrigin("B");
		routeMap5.setDestinationPoint("E");
		
		RouteMap routeMap6 = new RouteMap();
		routeMap6.setDistancePoints(7d);
		routeMap6.setPointOrigin("E");
		routeMap6.setDestinationPoint("F");
		
		RouteMap routeMap7 = new RouteMap();
		routeMap7.setDistancePoints(6d);
		routeMap7.setPointOrigin("B");
		routeMap7.setDestinationPoint("D");
		
		RouteMap routeMap8 = new RouteMap();
		routeMap8.setDistancePoints(2d);
		routeMap8.setPointOrigin("E");
		routeMap8.setDestinationPoint("D");
		
		
		routefound.add(routeMap);
		routefound.add(routeMap2);
		routefound.add(routeMap3);
		routefound.add(routeMap4);
		routefound.add(routeMap5);
		routefound.add(routeMap6);
		routefound.add(routeMap7);
		routefound.add(routeMap8);
		
		return routefound;
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
		
		assertNotNull(savedRouteMap.getId());
		assertEquals(mapEntity.getName(), savedRouteMap.getName());
	}
	
	@Test
	public void findLogisticMapByName(){
		
		LogisticMap logisticMap = populateLogisticMapEntity();
		Mockito.when(logisticsRepository.findByName(Mockito.anyString())).thenReturn(logisticMap);
		
		String name = "SP";
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
		logisticMap.setName("SP");
		List<RouteMap> routeMap = new ArrayList<>();
		RouteMap map = new RouteMap();
		map.setPointOrigin("Campinas");;
		map.setDestinationPoint("Rio Claro");
		map.setDistancePoints(10d);
		routeMap.add(map);
		logisticMap.setListRoutesMaps(routeMap );
		return logisticMap;
	}
 
	private LogisticMapRequest populateLogisticMapRequest() {
		LogisticMapRequest logisticMap = new LogisticMapRequest();
		logisticMap.setName("SP");
		List<RouteMapRequest> routeMap = new ArrayList<>();
		RouteMapRequest map = new RouteMapRequest();
		map.setPointOrigin("Campinas");;
		map.setDestinationPoint("Rio Claro");
		map.setDistancePoints("10");
		routeMap.add(map);
		logisticMap.setListRoutesMaps(routeMap );
		return logisticMap;
	}
	
}