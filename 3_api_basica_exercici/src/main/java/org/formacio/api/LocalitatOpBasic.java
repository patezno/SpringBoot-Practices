package org.formacio.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Modifica aquesta classe per tal que sigui un component Spring que realitza les 
 * operacions de persistencia tal com indiquen les firmes dels metodes
 */

@Component
public class LocalitatOpBasic {
	
	@PersistenceContext
	private EntityManager em;
	
	public Localitat carrega (long id) {
		return em.find(Localitat.class, id);
	}
	
	@Transactional
	public void alta (String nom, Integer habitants) {
		Localitat localitat = new Localitat();
		localitat.setNom(nom);
		localitat.setHabitants(habitants);
		em.persist(localitat);
	}
	
	@Transactional
	public void elimina (long id) {
		Localitat localitat = this.carrega(id);
		if (localitat != null) {
			em.remove(localitat);
		}
	}
	
	@Transactional
	public void modifica (Localitat localitat) {
	}

}
