package com.testetecnicomaximatech.controller.repository;

import com.testetecnicomaximatech.controller.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Page<Cliente> findByNomeOrEndereco_Logradouro(String nome, String endereco, Pageable pageable);
}
