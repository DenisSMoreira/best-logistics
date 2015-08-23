package br.com.walmart.logistics.controller.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Pojo de resposta, usado para um posivel tratamento especial de retorno para os consumidores
 * @author Denis soares moreira
 *
 */
@XmlRootElement(name="logisticMap")
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
	@XmlElement(name="listRoutesMaps")
	private List<RouteMapResponse> listRoutesMaps;

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
	 * @return routeMap {@link List<RouteMapResponse>}
	 */
	public List<RouteMapResponse> getListRoutesMaps() {
		return listRoutesMaps;
	}

	/**
	 * @param routeMap the routeMap to set
	 */
	public void setListRoutesMaps(List<RouteMapResponse> listRoutesMaps) {
		this.listRoutesMaps = listRoutesMaps;
	}

}
