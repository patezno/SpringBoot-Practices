package org.formacio.mvc;

import org.formacio.component.ServeiAlumnat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServeiAlumnatController {
	
	private ServeiAlumnat serveiAlumnat;
	
	@Autowired
	public void initialitza(ServeiAlumnat serveiAlumnat) {
		this.serveiAlumnat = serveiAlumnat;
	}
	
	@RequestMapping(path="/alumnes")
	@ResponseBody
	public int numAlumnes() {
		return serveiAlumnat.getSizeAlumnes();
	}

}
