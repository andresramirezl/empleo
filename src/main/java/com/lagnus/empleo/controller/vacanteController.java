package com.lagnus.empleo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lagnus.empleo.model.Vacante;
import com.lagnus.empleo.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class vacanteController {
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model){
		System.out.println("borrar vacante id: "+ idVacante);
		model.addAttribute("id", idVacante);
		return "mensaje";			
	}
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		
		Vacante vacante = serviceVacantes.buscarId(idVacante);
		//System.out.println("IdVacante: " + idVacante);
		model.addAttribute("vacante", vacante);
		System.out.println("vacante : " + vacante);
		return "Detail";
		
	}

}
