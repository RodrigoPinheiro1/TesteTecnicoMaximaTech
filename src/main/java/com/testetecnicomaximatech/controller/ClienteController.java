package com.testetecnicomaximatech.controller;

import com.testetecnicomaximatech.controller.dto.ClienteDto;
import com.testetecnicomaximatech.controller.service.impl.ClienteServiceImplemts;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImplemts clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteDto dto, UriComponentsBuilder builder) {

        ClienteDto cadastrar = clienteService.cadastrar(dto);


        URI uri = builder.path("/clientes/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(cadastrar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizar(@RequestBody @Valid ClienteDto dto, @PathVariable Long id) {

        ClienteDto atualizar = clienteService.atualizar(dto,id);


        return ResponseEntity.ok(atualizar);
    }

    @GetMapping
    public Page<ClienteDto>paginacao(@RequestParam(required = false) String nome, @RequestParam(required = false) String rua, Pageable pageable) {

      return clienteService.paginacao(nome,rua,pageable);
    }

}
