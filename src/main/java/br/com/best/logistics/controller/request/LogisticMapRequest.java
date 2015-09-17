package br.com.best.logistics.controller.request;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="logisticMap")
public class LogisticMapRequest {

	/**
	 * Nome ou apelido do mapa
	 */
	@Min(1)
    @Max(40)
    @NotNull
	private String name;

	/**
	 * Detalhes do mapa logistico que contem a rota
	 */
	@XmlElement(required=true, name="listRoutesMaps")
	private List<RouteMapRequest> listRoutesMaps;

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
	public List<RouteMapRequest> getListRoutesMaps() {
		return listRoutesMaps;
	}

	/**
	 * @param routeMap the routeMap to set
	 */
	public void setListRoutesMaps(List<RouteMapRequest> routeMap) {
		this.listRoutesMaps = routeMap;
	}
	

}
