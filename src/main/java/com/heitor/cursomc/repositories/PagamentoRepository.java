package com.heitor.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heitor.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
