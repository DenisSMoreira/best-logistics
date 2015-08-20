package br.com.walmart.logistics.core.generic;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * 
 * @author Denis soares moreira
 *
 */
public class Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	/**
	 * Obtém o valor da propriedade id
	 * @return id {@link String } 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Define o valor da propriedade id
	 * @param id {@link String } 
	 */
	public void setId(String id) {
		this.id = id;
	}
}
