package br.com.walmart.logistics.controller.request;

import java.util.List;

public class LogisticMapRequest {

	/**
	 * Nome ou apelido do mapa
	 */
	private String name;

	/**
	 * Detalhes do mapa logistico que contem a rota
	 */
	private List<RouteMapRequest> routeMap;

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
	 * @return routeMap {@link List<RouteMapRequest>}
	 */
	public List<RouteMapRequest> getRouteMap() {
		return routeMap;
	}

	/**
	 * @param routeMap the routeMap to set
	 */
	public void setRouteMap(List<RouteMapRequest> routeMap) {
		this.routeMap = routeMap;
	}
	

}
