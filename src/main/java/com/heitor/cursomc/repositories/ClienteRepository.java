package com.heitor.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heitor.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
