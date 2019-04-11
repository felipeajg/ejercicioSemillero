package com.hbt.semillero.servicios.rest.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;

@Stateless
public class ConsultasTransactionBean {

	 @PersistenceContext
		private EntityManager entityManager;
	    
	    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	    public List<Marca> consultar() {
	    	return entityManager.createQuery("select ma FROM Marca ms").getResultList();
	    }
	    
	    public List<Linea> consultarLinea(long idMarca){
	    	
	    	return entityManager.createQuery("select ln FROM Linea ln where ln.marca.idLinea =;ID_LINEA ")
	    			.setParameter("ID_LINEA", idMarca).getResultList();

	    	
	    }
}



