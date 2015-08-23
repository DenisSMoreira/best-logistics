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
	private List<RouteMap> listRoutesMaps;

	/**
	 * @return the routeMap
	 */
	public List<RouteMap> getListRoutesMaps() {
		return listRoutesMaps;
	}

	/**
	 * @param routeMap the routeMap to set
	 */
	public void setListRoutesMaps(List<RouteMap> listRouteMap) {
		this.listRoutesMaps = listRouteMap;
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
				+ ((listRoutesMaps == null) ? 0 : listRoutesMaps.hashCode());
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
		if (listRoutesMaps == null) {
			if (other.listRoutesMaps != null)
				return false;
		} else if (!listRoutesMaps.equals(other.listRoutesMaps))
			return false;
		return true;
	}

	
}
