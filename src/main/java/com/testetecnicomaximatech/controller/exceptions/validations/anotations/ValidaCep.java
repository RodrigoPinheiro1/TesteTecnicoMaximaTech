package com.testetecnicomaximatech.controller.exceptions.validations.anotations;

import com.testetecnicomaximatech.controller.exceptions.validations.classe.ValidacaoCep;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValidacaoCep.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface ValidaCep {


    String message() default "cep invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
