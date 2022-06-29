package com.lagnus.empleo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lagnus.empleo.model.Vacante;
import com.lagnus.empleo.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class vacanteController {
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	@GetMapping("/index")
	public String showIndex(Model model){
		
		List<Vacante> lista = serviceVacantes.buscarTodas();
		System.out.println(lista);
		model.addAttribute("vacantes", lista);
		
		//1. Obtener todas las vacantes (clase servicio)
		//2. Agregar al modelo el listado de vacantes
		//3. Renderizar las vacantes en la vista (integrar el archivo template-empleios/listVacantes)
		//4. Agregar al menu una opcion llamada "vacante" configurando la URL "vacabtes/index
		return "vacantes/listVacante";			
	}
	
	@GetMapping("/create")
	public String create(Vacante vacante, Model model){
		
		return "vacantes/formVacante";			
	}
	
	@PostMapping("/save")
	public String save(Vacante vacante,  BindingResult result, RedirectAttributes attributes){
		
		if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error "+ error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}
		
		
		
		serviceVacantes.guardar(vacante);
		System.out.println("Nombre Vacante: "+ vacante);
		attributes.addFlashAttribute("msg","Resgistro Guardado");
		return "redirect:/vacantes/index";			
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int idVacante, Model model){
		System.out.println("borrar vacante id: "+ idVacante);
		model.addAttribute("id", idVacante);
		return "mensaje";			
	}
	
	@GetMapping("/view/{id}")
	public String showDetail(@PathVariable("id") int idVacante, Model model) {
		
		Vacante vacante = serviceVacantes.buscarId(idVacante);
		//System.out.println("IdVacante: " + idVacante);
		model.addAttribute("vacante", vacante);
		System.out.println("vacante : " + vacante);
		return "Detail";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
