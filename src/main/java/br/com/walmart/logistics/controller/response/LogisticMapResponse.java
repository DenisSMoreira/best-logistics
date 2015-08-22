package br.com.walmart.logistics.controller.response;

import java.util.List;

/**
 * Pojo de resposta, usado para um posivel tratamento especial de retorno para os consumidores
 * @author Denis soares moreira
 *
 */
public class LogisticMapResponse {

	/**
	 * Indentificador único 
	 */
	private String id;
	
	/**
	 * Nome ou apelido do mapa
	 */
	private String name;

	/**
	 * Detalhes do mapa logistico que contem a rota
	 */
	private List<RouteMapResponse> routeMap;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return routeMap {@link List<RouteMapResponse>}
	 */
	public List<RouteMapResponse> getRouteMap() {
		return routeMap;
	}

	/**
	 * @param routeMap the routeMap to set
	 */
	public void setRouteMap(List<RouteMapResponse> routeMap) {
		this.routeMap = routeMap;
	}

}
