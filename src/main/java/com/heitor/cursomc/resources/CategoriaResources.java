package com.heitor.cursomc.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResources {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> testeResouces() {
		System.out.println("Teste OK");
		return ResponseEntity.ok().body("Teste OK");
	}
}
