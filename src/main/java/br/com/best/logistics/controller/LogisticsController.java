/**
 * 
 */
package br.com.best.logistics.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import br.com.best.logistics.controller.request.LogisticMapRequest;
import br.com.best.logistics.controller.response.LogisticMapResponse;
import br.com.best.logistics.controller.response.TravelLowerCostResponse;
import br.com.best.logistics.core.entity.LogisticMap;
import br.com.best.logistics.service.LogisticsService;

/**
 * @author Denis soares moreira
 * 
 */
@Api(value = "logisticsController", description = "Camada de controle de orquestração da logistica das rotas")
@RestController
@RequestMapping("/logistics")
public class LogisticsController {

	@Autowired
	private LogisticsService logisticsService;
	
	/**
	 * Retorna todas as rotas postadas anteriormente
	 * 
	 * @return List<LogisticMap.class>
	 */
	@RequestMapping(value = "/findAllRoutesMaps", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	@ApiOperation(value = "findAllRoutesMaps", notes = "Retorna todas as rotas cadastradas anteriormente", response =  LogisticMapResponse.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public @ResponseBody List<LogisticMapResponse> findAllRoutesMaps() {
		
		
		return logisticsService.findAllRoutesMaps();
	}
	
	/**
	 * Retorna todas as rotas postadas anteriormente
	 * 
	 * @return List<LogisticMap.class>
	 */
	@RequestMapping(value = "/findLogisticMapByName", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	@ApiOperation(value = "findLogisticMapByName", notes = "Consulta Mapa logistico pelo nome ou apelido", response =  LogisticMapResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public @ResponseBody LogisticMapResponse findLogisticMapByName(
												@RequestParam(name="name", required=true) String name){
		
		return logisticsService.findLogisticMapByName(name);
	}
	
	/**
	 * Retorna todas as rotas postadas anteriormente
	 * 
	 * @return List<LogisticMap.class>
	 */
	@RequestMapping(value = "/saveRouteMap", method = RequestMethod.POST, produces="application/json; charset=utf-8")
	@ApiOperation(value = "saveRouteMap", notes = "Salva uma rota" , response =  LogisticMap.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public @ResponseBody LogisticMapResponse saveRouteMap(	
			@Valid @RequestBody LogisticMapRequest logisticMapRequest) {
	
		
		return logisticsService.saveRouteMap(logisticMapRequest);
	}

	/**
	 * Cacula a melhor rota com menor custo
	 * 
	 * @return List<LogisticMap.class>
	 * @throws Exception 
	 */
	@RequestMapping(value = "/calculateLowerCostRoute", method = RequestMethod.POST, produces="application/json; charset=utf-8")
	@ApiOperation(value = "calculateLowerCostRoute", notes = "Cacula a melhor rota com menor custo" , response =  TravelLowerCostResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public @ResponseBody TravelLowerCostResponse calculateLowerCostRoute( 
											@RequestParam(required= true, name="nameMap") String nameMap,
											@RequestParam(required= true, name="pointOrigin") String pointOrigin,
											@RequestParam(required= true, name="destinationPoint") String destinationPoint,
											@RequestParam(required= true, name="autonomy") Double autonomy,
											@RequestParam(required= true, name="value") Double value) throws Exception{
		
		return logisticsService.calculateLowerCostRoute(nameMap, pointOrigin , destinationPoint, autonomy, value);
	}
	
	
	
	
}