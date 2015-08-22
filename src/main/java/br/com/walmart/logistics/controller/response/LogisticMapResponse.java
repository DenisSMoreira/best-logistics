package br.com.walmart.logistics.controller.response;

import java.util.List;

import br.com.walmart.logistics.core.entity.RouteMap;


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
	private List<RouteMap> routeMap;

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
	 * @return the routeMap
	 */
	public List<RouteMap> getRouteMap() {
		return routeMap;
	}

	/**
	 * @param routeMap the routeMap to set
	 */
	public void setRouteMap(List<RouteMap> routeMap) {
		this.routeMap = routeMap;
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

}
