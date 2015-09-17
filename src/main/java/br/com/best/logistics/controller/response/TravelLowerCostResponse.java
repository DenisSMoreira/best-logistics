package br.com.best.logistics.controller.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Pojo de resposta, usado para um posivel tratamento especial de retorno para os consumidores
 * @author Denis soares moreira
 *
 */
@XmlRootElement(name="travelLowerCost")
public class TravelLowerCostResponse {

	@XmlElement(name="logisticMap")
	private LogisticMapResponse logisticMapResponse;
	private String autonomy;
	private String valueFuel;
	private String costTotal;
	/**
	 * @return logisticMapResponse {@link LogisticMapResponse}
	 */
	public LogisticMapResponse getLogisticMapResponse() {
		return logisticMapResponse;
	}
	/**
	 * @param logisticMapResponse the logisticMapResponse to set
	 */
	public void setLogisticMapResponse(LogisticMapResponse logisticMapResponse) {
		this.logisticMapResponse = logisticMapResponse;
	}
	/**
	 * @return autonomy {@link String}
	 */
	public String getAutonomy() {
		return autonomy;
	}
	/**
	 * @param autonomy the autonomy to set
	 */
	public void setAutonomy(String autonomy) {
		this.autonomy = autonomy;
	}
	/**
	 * @return valueFuel {@link String}
	 */
	public String getValueFuel() {
		return valueFuel;
	}
	/**
	 * @param valueFuel the valueFuel to set
	 */
	public void setValueFuel(String valueFuel) {
		this.valueFuel = valueFuel;
	}
	/**
	 * @return costTotal {@link String}
	 */
	public String getCostTotal() {
		return costTotal;
	}
	/**
	 * @param costTotal the costTotal to set
	 */
	public void setCostTotal(String costTotal) {
		this.costTotal = costTotal;
	}
	
}
