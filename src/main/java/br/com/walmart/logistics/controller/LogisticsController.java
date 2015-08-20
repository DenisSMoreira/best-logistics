/**
 * 
 */
package br.com.walmart.logistics.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import br.com.walmart.logistics.core.entity.LogisticMap;

/**
 * @author Denis soares moreira
 * 
 */
@Api(value = "logisticsController", description = "Camada de controle de orquestração da logistica das rotas")
@RestController
@RequestMapping("/")
public class LogisticsController {

	/**
	 * Retorna todas as rotas postadas anteriormente
	 * 
	 * @return List<LogisticMap.class>
	 * @throws Exception
	 */
	@RequestMapping(value = "/findAll/{idInit}", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	@ApiOperation(value = "findAll", notes = "Retorna todas as rotas postadas anteriormente", response =  LogisticMap.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public @ResponseBody List<LogisticMap> findAll() throws Exception{
		
		
		return null;
	}

 
}