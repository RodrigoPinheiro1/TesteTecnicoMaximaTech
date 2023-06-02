package com.testetecnicomaximatech.controller.service.impl;

import com.testetecnicomaximatech.controller.dto.ClienteDto;
import com.testetecnicomaximatech.controller.dto.EnderecoDto;
import com.testetecnicomaximatech.controller.exceptions.ClientNotFound;
import com.testetecnicomaximatech.controller.model.Cliente;
import com.testetecnicomaximatech.controller.model.Endereco;
import com.testetecnicomaximatech.controller.repository.ClienteRepository;
import com.testetecnicomaximatech.controller.service.CepService;
import com.testetecnicomaximatech.controller.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImplemts implements ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CepService cepService;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ClienteDto cadastrar(ClienteDto dto) {

        Cliente cliente = modelMapper.map(dto, Cliente.class);

        EnderecoDto enderecoDto = cepService.apiCep(dto.getEndereco());

        Endereco endereco = modelMapper.map(enderecoDto, Endereco.class);

        return getClienteDto(cliente, endereco, dto);


    }

    @Override
    public Page<ClienteDto> paginacao(String nome, String rua, Pageable pageable) {

        return clienteRepository.findByNomeOrEndereco_Logradouro(nome, rua, pageable).map(cliente -> modelMapper.map(cliente, ClienteDto.class));

    }

    @Override
    public ClienteDto atualizar(ClienteDto dto, Long id) {
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        EnderecoDto enderecoDto = cepService.apiCep(dto.getEndereco());
        Endereco endereco = modelMapper.map(enderecoDto, Endereco.class);


        cliente.setId(id);

        return getClienteDto(cliente, endereco, dto);
    }

    private ClienteDto getClienteDto(Cliente cliente, Endereco endereco, ClienteDto dto) {

        endereco.setComplemento(dto.getEndereco().getComplemento());
        endereco.setNumero(dto.getEndereco().getNumero());

        cliente.setNome(dto.getNome());
        cliente.setCpnj(dto.getCpnj());
        cliente.setCodigo(dto.getCodigo());
        cliente.setEndereco(endereco);

        clienteRepository.save(cliente);
        return modelMapper.map(cliente, ClienteDto.class);
    }

}
