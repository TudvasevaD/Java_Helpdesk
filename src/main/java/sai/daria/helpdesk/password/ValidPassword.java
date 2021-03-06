package sai.daria.helpdesk.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Retention(RUNTIME)
@Target({TYPE, ANNOTATION_TYPE})
public @interface ValidPassword {

    String message() default "Неверный пароль";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

