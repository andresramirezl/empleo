package com.lagnus.empleo.service;

import java.util.List;

import com.lagnus.empleo.model.Vacante;

public interface IVacantesService {
	List<Vacante> buscarTodas();
	Vacante buscarId(Integer idVacante);
	void guardar(Vacante vacante);
}
