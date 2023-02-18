package com.examen.service;

import java.util.List;

import com.examen.Datos.Datos;
import com.examen.res.dto.RendimientoDTO;

public interface ICalculoInversionService {
	public List<RendimientoDTO> calculaInversion(Datos datos);
}
