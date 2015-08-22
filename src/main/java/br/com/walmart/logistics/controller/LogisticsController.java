/**
 * 
 */
package br.com.walmart.logistics.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.walmart.logistics.controller.request.LogisticMapRequest;
import br.com.walmart.logistics.controller.response.LogisticMapResponse;
import br.com.walmart.logistics.controller.response.RouteMapResponse;
import br.com.walmart.logistics.core.entity.LogisticMap;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author Denis soares moreira
 * 
 */
@Api(value = "logisticsController", description = "Camada de controle de orquestração da logistica das rotas")
@RestController
@RequestMapping("/logistics")
public class LogisticsController {

	/**
	 * Retorna todas as rotas postadas anteriormente
	 * 
	 * @return List<LogisticMap.class>
	 */
	@RequestMapping(value = "/findAllRoutesMaps", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	@ApiOperation(value = "findAllRoutesMaps", notes = "Retorna todas as rotas cadastradas anteriormente", response =  LogisticMap.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public @ResponseBody List<LogisticMap> findAllRoutesMaps() {
		
		
		return null;
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
												@RequestParam String name){
		
		return null;
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
												@RequestBody LogisticMapRequest logisticMapRequest) {
	
		
		LogisticMapResponse logisticMap = null;
		return logisticMap;
	}

 
	/**
	 * Salva uma lista de rotas, muito útil para as aplicações que vão consumir
	 * 
	 * @return List<LogisticMap.class>
	 */
	@RequestMapping(value = "/saveListRoutesMaps", method = RequestMethod.POST, produces="application/json; charset=utf-8")
	@ApiOperation(value = "saveListRoutesMaps", notes = "Salva uma lista de rotas, muito útil para as aplicações que vão consumir" , 
				  response =  LogisticMapResponse.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public @ResponseBody List<LogisticMapResponse> saveListRoutesMaps(
													@RequestBody List<LogisticMapRequest> listLogisticMapRequests) {
	
		
		List<LogisticMapResponse> logisticMap = null;
		return logisticMap;
	}
	
	/**
	 * Cacula a melhor rota com menor custo
	 * 
	 * @return List<LogisticMap.class>
	 */
	@RequestMapping(value = "/calculateLowerCostRoute", method = RequestMethod.POST, produces="application/json; charset=utf-8")
	@ApiOperation(value = "calculateLowerCostRoute", notes = "Cacula a melhor rota com menor custo" , response =  LogisticMapResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public @ResponseBody RouteMapResponse calculateLowerCostRoute( 
											@RequestParam("pointOrigin") String pointOrigin,
											@RequestParam("destinationPoint") String destinationPoint,
											@RequestParam("autonomy") Double autonomy,
											@RequestParam("value") Double value){
		
		return null;
	}
	
	
	
	
}