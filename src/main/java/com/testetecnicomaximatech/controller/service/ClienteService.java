package com.testetecnicomaximatech.controller.service;


import com.testetecnicomaximatech.controller.dto.ClienteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface ClienteService {


    ClienteDto cadastrar(ClienteDto clienteDto);

   Page<ClienteDto> paginacao(String nome, String endereco, Pageable pageable);

    ClienteDto atualizar(ClienteDto dto, Long id);


}
