package com.hbt.semillero.dto;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * clase temporar de persona
 * @author felipe jamioy
 *
 */
public class PersonaDTO implements Serializable {
	
	/**
	 * atributos
	 */
	
	private Long idPersona;

	private String numeroIdentificacion;

	private String tipoIdentificacion;

	private String numeroTelefonico;

	private String nombres;

	private String apellidos;
	
	private boolean vendedor;
	
	private boolean comprador;

	private Long edad;

	/**
	 * metodos get y set de los atributos
	 * @return
	 */
	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Long getEdad() {
		return edad;
	}
	
	
	public boolean isVendedor() {
		return vendedor;
	}

	public void setVendedor(boolean vendedor) {
		this.vendedor = vendedor;
	}

	public boolean isComprador() {
		return comprador;
	}

	public void setComprador(boolean comprador) {
		this.comprador = comprador;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}
	
	
	
	

}
