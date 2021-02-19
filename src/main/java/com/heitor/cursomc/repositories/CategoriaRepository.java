package com.heitor.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heitor.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
