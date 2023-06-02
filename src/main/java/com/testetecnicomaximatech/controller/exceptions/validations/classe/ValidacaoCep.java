package com.testetecnicomaximatech.controller.exceptions.validations.classe;

import com.testetecnicomaximatech.controller.dto.EnderecoDto;
import com.testetecnicomaximatech.controller.exceptions.validations.anotations.ValidaCep;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class ValidacaoCep implements ConstraintValidator<ValidaCep, EnderecoDto> {

    @Override
    public void initialize(ValidaCep constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(EnderecoDto dto, ConstraintValidatorContext constraintValidatorContext) {

        if (dto.getCep().length() == 8) {

            return true;
        }

        return false;
    }
}
