package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * 
 * @author felipe jamioy
 *
 */
public class ResultadoDTO implements Serializable {
	
	/**
	 * atributos
	 */
	private boolean exitoso;
	
	private String mensajeError;

	public boolean isExitoso() {
		return exitoso;
	}

	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	

}
