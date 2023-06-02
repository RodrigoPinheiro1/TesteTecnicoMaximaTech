package com.testetecnicomaximatech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testetecnicomaximatech.controller.dto.ClienteDto;
import com.testetecnicomaximatech.controller.dto.EnderecoDto;
import com.testetecnicomaximatech.controller.model.Cliente;
import com.testetecnicomaximatech.controller.model.Endereco;
import com.testetecnicomaximatech.controller.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClienteRepository clienteRepository;


    private Cliente cliente;

    private ClienteDto clienteDto;

    private EnderecoDto enderecoDto;

    private final URI uri = URI.create("/clientes");

    private final URI uriId = URI.create("/clientes/");
    private final String idNotExist = "000";
    private String idString;

    @BeforeAll
    void put() {
        cliente = new Cliente("xandao", "codigo", "cpnj",
                new Endereco("03101010", "30", "sdsad", "dsad", "sdasda", "dasd"
                        , "dsasad", "asd", "dsa", "dsa", "ads"));


        clienteRepository.save(cliente);
        idString = String.valueOf(cliente.getId());
    }

    @BeforeEach
    void setUp() {
        enderecoDto = new EnderecoDto("08568000", "apto 47", "123123");

        clienteDto = new ClienteDto("nome", "codigo", "15.436.940/0001-03",
                enderecoDto);

    }

    @Test
    void insertWithCorrectCnpjAndCep() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void insertWithWrongCnpjAndCep() throws Exception {

        clienteDto.setCpnj("2138923109213");
        enderecoDto.setCep("12345");

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDto)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());


    }

    @Test
    void updateWithCorrectCnpjAndCep() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(uriId + idString)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateWithWrongCnpjAndCep() throws Exception {
        clienteDto.setCpnj("2138923109213");
        enderecoDto.setCep("12345");

        mockMvc.perform(MockMvcRequestBuilders.put(uriId + idString)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDto)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void paginacao() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .param("nome", "xandao"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}