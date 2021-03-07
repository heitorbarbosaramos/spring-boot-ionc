package com.heitor.cursomc.domain.DTO;

import com.heitor.cursomc.domain.Categoria;

public class CategoriaDTO {

	private String name;

	public CategoriaDTO(Categoria obj) {
		this.name = obj.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
