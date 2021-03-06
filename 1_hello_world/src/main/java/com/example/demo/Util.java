package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class Util {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void alta (long id, String nom) {
		Persona nova = new Persona();
		nova.setId(id);
		nova.setNom(nom);
		em.persist(nova);
	}
}
