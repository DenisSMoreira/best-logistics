package br.com.best.logistics.core.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Detalhes do mapa logistico 
 * @author Denis soares moreira
 *
 */
@Document
public class RouteMap {

	/**
	 * Indentificador único 
	 */
	private String id;
	
	/**
	 * Ponto de origem
	 */
	private String pointOrigin;
	
	/**
	 * Ponto de destino
	 */
	private String destinationPoint;
	
	/**
	 * Distância entre os pontos em quilômetros
	 */
	private Double distancePoints;

	/**
	 * @return the pointOrigin
	 */
	public String getPointOrigin() {
		return pointOrigin;
	}

	/**
	 * @param pointOrigin the pointOrigin to set
	 */
	public void setPointOrigin(String pointOrigin) {
		this.pointOrigin = pointOrigin;
	}

	/**
	 * @return the destinationPoint
	 */
	public String getDestinationPoint() {
		return destinationPoint;
	}

	/**
	 * @param destinationPoint the destinationPoint to set
	 */
	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	/**
	 * @return the distancePoints
	 */
	public Double getDistancePoints() {
		return distancePoints;
	}

	/**
	 * @param distancePoints the distancePoints to set
	 */
	public void setDistancePoints(Double distancePoints) {
		this.distancePoints = distancePoints;
	}

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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((destinationPoint == null) ? 0 : destinationPoint.hashCode());
		result = prime * result
				+ ((distancePoints == null) ? 0 : distancePoints.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((pointOrigin == null) ? 0 : pointOrigin.hashCode());
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
		RouteMap other = (RouteMap) obj;
		if (destinationPoint == null) {
			if (other.destinationPoint != null)
				return false;
		} else if (!destinationPoint.equals(other.destinationPoint))
			return false;
		if (distancePoints == null) {
			if (other.distancePoints != null)
				return false;
		} else if (!distancePoints.equals(other.distancePoints))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pointOrigin == null) {
			if (other.pointOrigin != null)
				return false;
		} else if (!pointOrigin.equals(other.pointOrigin))
			return false;
		return true;
	}
	
}
