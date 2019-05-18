package org.formacion.mvc;

import org.formacion.data.ComptesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ComptesController {

	@Autowired
	private ComptesRepository repositori;
	
	@RequestMapping(path="/moviment")
	@ResponseBody
	public String traspassa(String origen, String desti, int quantitat) {
		

		try {
			System.out.println("Primera operacio");
			repositori.moviment(desti, quantitat);

			System.out.println("Segona operacio");
			repositori.moviment(origen, -1 * quantitat);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Estat final:");
		System.out.println(repositori.info(origen));
		System.out.println(repositori.info(desti));
		return "ok";
	}
}
