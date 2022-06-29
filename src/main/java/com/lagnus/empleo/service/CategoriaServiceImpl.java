package com.lagnus.empleo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.lagnus.empleo.model.Categoria;
import com.lagnus.empleo.model.Vacante;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
	
	private LinkedList<Categoria> lista = null;
	
	public CategoriaServiceImpl() {
	
		lista = new LinkedList<Categoria>();
		
		Categoria categoria1 = new Categoria();
		categoria1.setId(1);
		categoria1.setName("Informatica");
		categoria1.setDescription("desarrollo software");
		
		
		Categoria categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setName("Ingenieria");
		categoria2.setDescription("Ingenieros mundiales");
		
		
		Categoria categoria3 = new Categoria();
		categoria3.setId(3);
		categoria3.setName("Contabilidad");
		categoria3.setDescription("contable pro ");
		
		
		Categoria categoria4 = new Categoria();
		categoria4.setId(4);
		categoria4.setName("Streamer");
		categoria4.setDescription("creador de contenido");
					
		lista.add(categoria1);
		lista.add(categoria2);
		lista.add(categoria3);
		lista.add(categoria4);

}


	
	public void guardar(Categoria categoria) {
		
		lista.add(categoria);
	}

	
	public LinkedList<Categoria> buscarTodas() {
		
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		
		for(Categoria c : lista) {
			if (c.getId() == idCategoria) {
				return c;
			}
		}
		return null;
	}

}
