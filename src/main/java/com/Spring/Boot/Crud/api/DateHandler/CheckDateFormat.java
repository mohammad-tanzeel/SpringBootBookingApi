package com.Spring.Boot.Crud.api.DateHandler;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CheckDateValidator.class)
public @interface CheckDateFormat {

    String message() default "{message.key}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String pattern();

}