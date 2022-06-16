package com.lagnus.empleo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lagnus.empleo.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacantesService{

	private List<Vacante> lista = null;
	
	public VacantesServiceImpl() {
					
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			lista = new LinkedList<Vacante>();
			
			try {
				
				Vacante vacante1 = new Vacante();
				vacante1.setId(1);
				vacante1.setName("Ingeniero comunicaciones");
				vacante1.setDescription("queremos un man pa que trabaje");
				vacante1.setDate(sdf.parse("08-02-2022"));
				vacante1.setSalary(100.00);
				vacante1.setDestacado(1);
				vacante1.setImagen("logo1.png");			
				
				Vacante vacante2 = new Vacante();
				vacante2.setId(2);
				vacante2.setName("Ingeniero casas");
				vacante2.setDescription("queremos un man pa que trabaje");
				vacante2.setDate(sdf.parse("08-12-2022"));
				vacante2.setSalary(1500.00);
				vacante2.setDestacado(0);
				vacante2.setImagen("logo2.png");		
				
				Vacante vacante3 = new Vacante();
				vacante3.setId(3);
				vacante3.setName("Ingeniero teleco");
				vacante3.setDescription("queremos un man pa que trabaje");
				vacante3.setDate(sdf.parse("08-01-2022"));
				vacante3.setSalary(18070.00);
				vacante3.setDestacado(1);
				vacante3.setImagen("logo3.png");	
				
				Vacante vacante4 = new Vacante();
				vacante4.setId(4);
				vacante4.setName("Ingeniero puentes festivos");
				vacante4.setDescription("queremos un man pa que trabaje");
				vacante4.setDate(sdf.parse("08-05-2022"));
				vacante4.setSalary(133800.00);
				vacante4.setDestacado(0);
				vacante4.setImagen("logo4.png");	
				
				lista.add(vacante1);
				lista.add(vacante2);
				lista.add(vacante3);
				lista.add(vacante4);
				
				
			}catch (ParseException e) {
				System.out.println("Error"+ e.getMessage());
			}
			
		
	}
	
	
	public List<Vacante> buscarTodas() {
		return lista;
	}


	
	public Vacante buscarId(Integer idVacante) {
		
		for(Vacante v : lista) {
			if (v.getId() == idVacante) {
				return v;
			}
		}
		return null;
	}
	
	

}
