package com.testetecnicomaximatech.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidacaoDto {

    private String campo;
    private String erro;


}
