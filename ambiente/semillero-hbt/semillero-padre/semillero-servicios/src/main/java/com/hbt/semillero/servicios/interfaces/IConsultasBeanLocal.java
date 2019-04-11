package com.hbt.semillero.servicios.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;

@Local
public interface IConsultasBeanLocal {
	
	/**
	 * metodo para consultar marcas
	 * @return
	 */
	public List<Marca> consultarMarcas();
	/**
	 * metodo para consultar lineas
	 * @param idMarca
	 * @return
	 */
	 public List<Linea> consultarLineas(long idMarca);
	 /**
	  * metodo para crear personas
	  * @param personaDTO
	  */
	 public void crearPersona(PersonaDTO personaDTO);
	 /*
	  * metodo para consultar personas
	  */
	 public List<Persona> consultarPersonas(String tipoIdentificacion, String numeroIdentificacion);
	 
	 /**
	  * Metodo editar persona
	  * @param personaDTO
	  */
	 public void editarPersonas(PersonaDTO personaDTO);

}
