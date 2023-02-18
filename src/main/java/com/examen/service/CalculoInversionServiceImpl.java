package com.examen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.Datos.Datos;
import com.examen.res.dto.RendimientoDTO;

@Service
public class CalculoInversionServiceImpl implements ICalculoInversionService {
	@Override
	public List<RendimientoDTO> calculaInversion(Datos datos) {
		List<RendimientoDTO> lista = new ArrayList<>();
		double total = datos.getInversionInicial();
		double aportAc = datos.getAportacionAnual();
		double aportaciones = 0;
		for(int i = 0; i < datos.getInvestYear(); i++ ) {
			RendimientoDTO res = new RendimientoDTO();
			res.setSaldoInicial(total);
			if(i> 0) {
				double porc = (datos.getPorcIncAnual() * 0.01);
				aportAc = Math.round((aportAc*porc) + aportAc);
			}
			res.setAportacionInic((double) Math.round(aportAc));
			double rend = Math.ceil(((total +  aportAc) * datos.getRendimientoInv() * 0.01));
			total = Math.round((i > 0 ? aportAc : datos.getAportacionAnual()) + rend + total);
			res.setYear(i+1);
			res.setRendimiento(rend);
			res.setSaldoFinal(total);
			aportaciones += aportAc;
			res.setGananciaInv(total - datos.getInversionInicial() - aportaciones);
			lista.add(res);
		}
		return lista;
	}

}
