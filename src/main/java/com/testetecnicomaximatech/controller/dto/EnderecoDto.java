package com.testetecnicomaximatech.controller.dto;

import com.testetecnicomaximatech.controller.exceptions.validations.anotations.ValidaCep;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnderecoDto {

    @NotBlank
    @NotNull
    private String cep;

    private String logradouro;

    private String complemento;

    private String numero;

    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;


}
