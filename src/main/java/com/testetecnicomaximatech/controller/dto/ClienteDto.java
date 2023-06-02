package com.testetecnicomaximatech.controller.dto;

import com.testetecnicomaximatech.controller.exceptions.validations.anotations.ValidaCep;
import com.testetecnicomaximatech.controller.model.Endereco;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
public class ClienteDto {

    private Long id;
    @NotBlank
    @NotNull
    private String nome;
    @NotBlank
    @NotNull
    private String codigo;
    @CNPJ
    private String cpnj;
    @Valid
    @NotNull
    @ValidaCep
    private EnderecoDto endereco;

}
