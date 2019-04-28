package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AgendaController {
	
	private AgendaService agenda;
	
	@Autowired
	public AgendaController(AgendaService agenda) {
		this.agenda = agenda;
	}
	
	@RequestMapping(path="/nombre")
	@ResponseBody
	public int getTotal() {
		return agenda.nombreContactes();
	}
	
	@RequestMapping(path="/telefon")
	@ResponseBody
	public String getTelefon(String id) {
		return agenda.recupera(id).getTelefon();
	}
	
	@RequestMapping(path="/contacte/{id}")
	@ResponseBody
	public Persona getContacte(@PathVariable String id) {
		return agenda.recupera(id);
	}
	
}
