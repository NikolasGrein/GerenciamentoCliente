package com.gerenciamentoClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamentoClientes.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
