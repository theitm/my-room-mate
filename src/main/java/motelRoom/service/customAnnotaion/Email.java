package motelRoom.service.customAnnotaion;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {
    String message() default "You have entered an invalid e-mail address. Please try again!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
