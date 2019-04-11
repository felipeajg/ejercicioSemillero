package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * Clase temporal de marca
 * @author felip
 *
 */
public class MarcaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * atributos
	 */
	
	private Long idMarca;
	
	private String nombre;

	public Long getIdMarca() {
		return idMarca;
	}
	
	/**
	 * metodo set de marca
	 * @param idMarca
	 */
	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	/**
	 * metodo que devuelve un nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * metodo set de un nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
