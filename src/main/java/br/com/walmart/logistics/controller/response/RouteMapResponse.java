package br.com.walmart.logistics.controller.response;

/**
 * Detalhes do mapa logistico 
 * @author Denis soares moreira
 *
 */
public class RouteMapResponse {

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
	
	
	
}
