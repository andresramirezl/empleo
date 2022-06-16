package com.lagnus.empleo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lagnus.empleo.model.Vacante;
import com.lagnus.empleo.service.IVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	@GetMapping("/table")
	public String showTable(Model model){
		
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		
		return "table";
		
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero informatico");
		lista.add("Mozo almacen");
		lista.add("rodaballero");
		lista.add("pastelero");
		
		model.addAttribute("empleos",lista);
		
		return "listado";
		
	}
	@GetMapping("/")
	public String showHome(Model model){
		
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
			
		return "home";
	}
	
	@GetMapping("/detail")
	public String showDetails(Model model) {
		
		Vacante vacante = new Vacante();
		vacante.setName("Ingeniero comunicaciones");
		vacante.setDescription("queremos un man pa que trabaje");
		vacante.setDate(new Date());
		vacante.setSalary(1800.00);
		
		model.addAttribute(vacante);
		
		return "Detail";
			
	}
		
}
