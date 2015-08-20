package br.com.walmart.logistics.core.entity;

import java.util.List;

/**
 * Mapa de logistica para entregas visando sempre o menor custo
 * @author Denis soares moreira
 */
public class LogisticMap {

	/**
	 * Indentificado unico 
	 */
	private String id;
	
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
	
	
	
}
