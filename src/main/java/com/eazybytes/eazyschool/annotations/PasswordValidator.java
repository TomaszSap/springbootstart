package com.eazybytes.eazyschool.annotations;


import com.eazybytes.eazyschool.validations.PasswordStrengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({METHOD,FIELD})
@Retention(RUNTIME)
public @interface PasswordValidator {
    String message() default "Please choose a strong password";
    Class<?>[] groups()default{};
    Class<? extends Payload>[] payload()default {};
}
