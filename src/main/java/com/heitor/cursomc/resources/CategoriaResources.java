package com.heitor.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heitor.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> testeResouces() {
		
		List<Categoria> lista = new ArrayList<Categoria>();
		
		lista.add(new Categoria(1, "Informática"));
		lista.add(new Categoria(1, "Escritório"));

		
		return ResponseEntity.ok().body(lista);
	}
}
