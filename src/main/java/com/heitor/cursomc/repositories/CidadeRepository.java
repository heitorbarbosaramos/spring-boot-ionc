package com.heitor.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heitor.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
