package com.hbt.semillero.servicios.rest.ejb;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Comprador;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Vendedor;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;

/**
 * 
 * @author felipe jamioy
 *
 */
@Stateless
public class ConsultasBean implements IConsultasBeanLocal
{
	
	 @PersistenceContext
		private EntityManager entityManager;
	 
	 	/**
	 	 * Método usado para consultar las marcas
	 	 */
	    
	    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	    public List<Marca> consultarMarcas() {
	    	return entityManager.createQuery("select ma FROM Marca ma").getResultList();
	    }
	    
	    /**
	     * Método usado para consultar las lineas por medio de una marca
	     */
	    public List<Linea> consultarLineas(long idMarca){	 
	    	
	    	Query consulta = entityManager.createQuery("Select ln from Linea ln JOIN FETCH ln.marca where ln.marca.idMarca=:idMarca");
	    			consulta.setParameter("idMarca", idMarca);
	    	return consulta.getResultList();
	    	
	    }
	    
	    /**
	     * Metodo utilizado para crear personas, este es un post
	     * @param persona
	     */
	    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	    public void crearPersona(PersonaDTO personaDTO) {
	    	
	    	Persona persona = new Persona();
	    	persona.setNombres(personaDTO.getNombres());
	    	persona.setApellidos(personaDTO.getApellidos());
	    	persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
	    	persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
	    	persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
	    	persona.setEdad(personaDTO.getEdad());
	    	
	    	entityManager.persist(persona);
	    	
	    	if(personaDTO.isComprador()) {
	    		Comprador comprador = new Comprador();
	    		comprador.setFechaAfiliacion(Calendar.getInstance());
	    		comprador.setPersona(persona);
	    		entityManager.persist(comprador);
	    	}
	    	if(personaDTO.isVendedor()) {
	    		
	    		Vendedor vendedor = new Vendedor();
	    		vendedor.setFechaIngreso(Calendar.getInstance());
	    		vendedor.setPersona(persona);
	    		entityManager.persist(vendedor);
	    		
	    		
	    		
	    	}
	    	
	    }
	    
	    /**
	     * Metodo para consultar una personas por medio de el tipo de id y el numero id
	     */
	    
	    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	    public List<Persona> consultarPersonas(String tipoIdentificacion, String numeroIdentificacion){
	    	
	    	Query consulta =  entityManager.createQuery("select per FROM Persona per where per.tipoIdentificacion=:tipoIdentificacion and  numeroIdentificacion=:numeroIdentificacion");
	    	consulta.setParameter("tipoIdentificacion", tipoIdentificacion);
	    	consulta.setParameter("numeroIdentificacion", numeroIdentificacion);
	    	return consulta.getResultList();

	    	
	    }
	    
	    /**
	     * Metodo usado para editar personas
	     * @param persona	    
	     */
	    public void editarPersonas(PersonaDTO personaDTO) {
	    	
	    	Persona persona = entityManager.find(Persona.class, personaDTO.getIdPersona());
	    	persona.setNombres(personaDTO.getNombres());
	    	persona.setApellidos(personaDTO.getApellidos());
	    	persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
	    	persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
	    	persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
	    	persona.setEdad(personaDTO.getEdad());
	    	
	    	entityManager.persist(persona);
	    	
	    	if(personaDTO.isComprador()) {
	    		Comprador comprador = new Comprador();
	    		comprador.setFechaAfiliacion(Calendar.getInstance());
	    		comprador.setPersona(persona);
	    		entityManager.persist(comprador);
	    	}
	    	if(personaDTO.isVendedor()) {
	    		
	    		Vendedor vendedor = new Vendedor();
	    		vendedor.setFechaIngreso(Calendar.getInstance());
	    		vendedor.setPersona(persona);
	    		entityManager.persist(vendedor);
	    		
	    		
	    		
	    	}
	    	
	    }


}





	

