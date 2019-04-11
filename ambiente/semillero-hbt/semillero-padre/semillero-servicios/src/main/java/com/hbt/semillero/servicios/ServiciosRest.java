package com.hbt.semillero.servicios;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.swing.text.MaskFormatter;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.hbt.semillero.dto.LineaDTO;
import com.hbt.semillero.dto.MarcaDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;
import com.hbt.semillero.servicios.rest.ejb.ConsultasBean;

@Path("/serviciosRest")
public class ServiciosRest {
	
	@EJB
	private IConsultasBeanLocal consultaBean;
	
	
	/**
	 * Servicio para consultar marcas por medio del metodo
	 * @return marca
	 */
	@GET
	@Path("/consultarMarcas")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<MarcaDTO> consultarMarcas(){
		List<Marca> marcas = consultaBean.consultarMarcas();
		List<MarcaDTO> retorno = new ArrayList<>();
		for(Marca marca:marcas) {
			MarcaDTO marcaDTO = construirMarcaDTO(marca);
			retorno.add(marcaDTO);
		}		
		return retorno;
		
	}
	
	/**
	 * Servicio para consultar linea por medio de una marca
	 * @param idMarca
	 * @return linea
	 */
	@GET
	@Path("/consultarLineas")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<LineaDTO> consultarLineas(@QueryParam(value = "idMarca") Long idMarca){
		List<Linea> lineas = consultaBean.consultarLineas(idMarca);
		List<LineaDTO> retorno = new ArrayList<>();
		for (Linea linea : lineas) {
			LineaDTO lineaDTO = new LineaDTO();
			lineaDTO.setIdLinea(linea.getIdLinea());
			lineaDTO.setCilindraje(linea.getCilindraje());
			lineaDTO.setNombre(linea.getNombre());
			MarcaDTO marcaDTO = construirMarcaDTO(linea.getMarca());
			lineaDTO.setMarca(marcaDTO);
		   retorno.add(lineaDTO);	
			
		}
		
		return retorno;
		
		
	}
	
	/**
	 * Servicio para crear un usuario
	 * @param personaDTO
	 * @return
	 */
	@POST
	@Path("/crearCliente")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO){
		
		ResultadoDTO retorno = new ResultadoDTO();		
		retorno.setExitoso(true);
		
		try {		
			
			consultaBean.crearPersona(personaDTO);

		}catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensajeError("no se puede ingresar la persona");
		}
		
		return retorno;
		
	}
	
	/**
	 * Metodo para crear una marca
	 * @param marca
	 * @return
	 */
	private MarcaDTO construirMarcaDTO(Marca marca) {
		MarcaDTO marcaDTO = new MarcaDTO();
		marcaDTO.setIdMarca(marca.getIdMarca());
		marcaDTO.setNombre(marca.getNombre());
		return marcaDTO;
	}
	
	/**
	 * Metodo para consultar una persona con el tipo de id y el número
	 * @param tipoIdentificacion
	 * @param numeroIdentificacion
	 * @return
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas(@QueryParam(value = "tipoIdentificacion") String tipoIdentificacion, @QueryParam(value = "numeroIdentificacion") String numeroIdentificacion){
		List<Persona> personas = consultaBean.consultarPersonas(tipoIdentificacion, numeroIdentificacion);
		List<PersonaDTO> retorno = new ArrayList<>();
		for (Persona persona : personas) {
			PersonaDTO personaDTO = new PersonaDTO();
			personaDTO.setNombres(persona.getNombres());
			personaDTO.setApellidos(persona.getApellidos());
			personaDTO.setTipoIdentificacion(persona.getTipoIdentificacion());
			personaDTO.setNumeroTelefonico(persona.getNumeroTelefonico());
			personaDTO.setEdad(persona.getEdad());
		   retorno.add(personaDTO);	
			
		}
		
		return retorno;
		
		
	}
	
	/**
	 * Servicio para editar una persona
	 * @param personaDTO
	 * @return
	 */
	@POST
	@Path("/editarPersona")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	 public void editarPersonas(PersonaDTO personaDTO){
		
		ResultadoDTO retorno = new ResultadoDTO();		
		retorno.setExitoso(true);
		
		try {		
			
			consultaBean.editarPersonas(personaDTO);

		}catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensajeError("no se puede edtitar la persona");
		}
		
		
	}
	
	

}
