package com.lagnus.empleo.controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lagnus.empleo.model.Categoria;
import com.lagnus.empleo.service.ICategoriaService;

@Controller
@RequestMapping(value="/categorias")
public class categoriasController {
	
	
	@Autowired
	private ICategoriaService serviceCategoria;
	
		
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index")
	public String showIndex(Model model, Categoria categoria) {
		
		LinkedList<Categoria> lista =  serviceCategoria.buscarTodas();
		System.out.println("categorias " + lista);
		model.addAttribute("categorias", lista);
		
		return "categorias/listCategorias";
	}
	
	//@RequestMapping(value="/create", method=RequestMethod.GET)
	@GetMapping("/create")
	public String create(Categoria categoria) {
		return "categorias/formCategorias";
	}
	
	//@RequestMapping(value="/save", method=RequestMethod.POST)
	//@GetMapping("/save")
	@PostMapping("/save")
	public String save(Categoria categoria,BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error "+ error.getDefaultMessage());
			}
			return "vacantes/formCategorias";
		}
		serviceCategoria.guardar(categoria);
		System.out.println("Nombre Categoria: "+ categoria);
		attributes.addFlashAttribute("msg","Categoria Guardada");
		return "redirect:/categorias/index";			
		
	}


}
