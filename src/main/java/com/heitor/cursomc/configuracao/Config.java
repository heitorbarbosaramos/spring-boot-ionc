package com.heitor.cursomc.configuracao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.heitor.cursomc.domain.Categoria;
import com.heitor.cursomc.repositories.CategoriaRepository;

@Configuration
public class Config implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Escrtório");
		Categoria cat2 = new Categoria(null, "Informática");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
