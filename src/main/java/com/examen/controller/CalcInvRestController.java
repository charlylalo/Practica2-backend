package com.examen.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.Datos.Datos;
import com.examen.res.dto.RendimientoDTO;
import com.examen.service.ICalculoInversionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CalcInvRestController {
	
	@Autowired
	private ICalculoInversionService calculoService;
	
	@PostMapping("/calcula")
	public ResponseEntity<?> Calculadora(@RequestBody Datos datos ) {
		Map <String, Object> response = new HashMap<>();
		List<RendimientoDTO> respuesta = new ArrayList<>();
		try {
			if (datos.getInversionInicial() < 1000) throw new Exception("La inversión inicial debe ser mayor a $1000.00");
			if (datos.getInvestYear() == null || datos.getInvestYear() <= 0) throw new Exception("El porcentaje de aportación anual no puede ser cero o negativo");
			if (datos.getRendimientoInv() == null || datos.getRendimientoInv() <= 0) throw new Exception("El rendimiento de inversión no puede ser cero o negativo");
			respuesta = calculoService.calculaInversion(datos);
		} catch (Exception e) {
			response.put("Error", "No es posible procesar su solicitud con los datos proporcionados");
			response.put("Causa", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(respuesta, HttpStatus.OK) ;
	}

}
