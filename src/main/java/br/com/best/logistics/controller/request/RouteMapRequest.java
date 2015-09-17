package br.com.best.logistics.controller.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Detalhes do mapa logistico 
 * @author Denis soares moreira
 *
 */
@XmlRootElement(name="RouteMap")
public class RouteMapRequest {

	/**
	 * Ponto de origem
	 */
    @Min(1)
    @Max(30)
    @NotNull
	private String pointOrigin;
	
	/**
	 * Ponto de destino
	 */
    @Min(1)
    @Max(30)
    @NotNull
	private String destinationPoint;
	
	/**
	 * Distância entre os pontos em quilômetros
	 */
    @Min(1)
    @Max(10)
    @NotNull
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
