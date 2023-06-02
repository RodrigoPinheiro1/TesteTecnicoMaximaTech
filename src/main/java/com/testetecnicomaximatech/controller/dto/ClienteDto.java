package com.testetecnicomaximatech.controller.dto;

import com.testetecnicomaximatech.controller.exceptions.validations.anotations.ValidaCep;
import com.testetecnicomaximatech.controller.model.Endereco;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@AllArgsConstructor
@NoArgsConstructor
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


    public ClienteDto(String nome, String codigo, String cpnj, EnderecoDto endereco) {
        this.nome = nome;
        this.codigo = codigo;
        this.cpnj = cpnj;
        this.endereco = endereco;
    }
}
