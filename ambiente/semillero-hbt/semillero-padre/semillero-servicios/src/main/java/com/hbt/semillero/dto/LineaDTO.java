package com.hbt.semillero.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hbt.semillero.entidades.Marca;

/**
 * clase temporal de linea
 * @author felip
 *
 */
public class LineaDTO implements Serializable {
	
	
	private Long idLinea;

	
	private String nombre;

	
	private int cilindraje;

	
	private MarcaDTO marca;


	/*
	 * metodo que devuelve el id de la linea
	 */
	public Long getIdLinea() {
		return idLinea;
	}

	/**
	 * metodo para set de linea
	 * @param idLinea
	 */
	public void setIdLinea(Long idLinea) {
		this.idLinea = idLinea;
	}


	/*
	 * metodo que devuelve el nnombre de la linea
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * metodo set de nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * metodo que devuelve el cilindraje de la linea
	 */
	public int getCilindraje() {
		return cilindraje;
	}

	/**
	 * metodo set de cilindraje
	 * @param cilindraje
	 */
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	/*
	 * metodo que devuelve la marca de la linea
	 */
	public MarcaDTO getMarca() {
		return marca;
	}

	/**
	 * metodo set de marca
	 * @param marca
	 */
	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}
	
	

}
