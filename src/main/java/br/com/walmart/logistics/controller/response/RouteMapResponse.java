package br.com.walmart.logistics.controller.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Detalhes do mapa logistico 
 * @author Denis soares moreira
 *
 */
@XmlRootElement(name="routeMap")
public class RouteMapResponse {

	
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
	private String distancePoints;

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
	public String getDistancePoints() {
		return distancePoints;
	}

	/**
	 * @param distancePoints the distancePoints to set
	 */
	public void setDistancePoints(String distancePoints) {
		this.distancePoints = distancePoints;
	}
	
}
