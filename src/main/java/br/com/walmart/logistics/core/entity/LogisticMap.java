package br.com.walmart.logistics.core.entity;

import java.util.List;

import br.com.walmart.logistics.core.generic.Entity;

/**
 * Mapa de logistica para entregas
 * @author Denis soares moreira
 */
public class LogisticMap extends Entity {

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6385455737907275124L;

	/**
	 * Nome ou apelido do mapa
	 */
	private String name;

	/**
	 * Detalhes do mapa logistico que contem a rota
	 */
	private List<RouteMap> routeMap;

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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((routeMap == null) ? 0 : routeMap.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogisticMap other = (LogisticMap) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (routeMap == null) {
			if (other.routeMap != null)
				return false;
		} else if (!routeMap.equals(other.routeMap))
			return false;
		return true;
	}

	
}
