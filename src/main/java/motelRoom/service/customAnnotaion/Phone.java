package motelRoom.service.customAnnotaion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PhoneNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    String message() default "Invalid phone number format! (Ex:0xxxxxxxxx)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
