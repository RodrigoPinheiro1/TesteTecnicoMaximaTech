package com.testetecnicomaximatech.controller.service;

import com.testetecnicomaximatech.controller.dto.EnderecoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    public EnderecoDto apiCep(EnderecoDto enderecoDto) {
        RestTemplate restTemplate = new RestTemplate();

        String URI = "https://viacep.com.br/ws/" + enderecoDto.getCep()+"/json/";

        return restTemplate.getForObject(URI, EnderecoDto.class);
    }
}
