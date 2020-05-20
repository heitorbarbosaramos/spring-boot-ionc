package com.heitor.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heitor.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
