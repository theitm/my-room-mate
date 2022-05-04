package motelRoom.service.customAnnotaion;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Constraint(validatedBy=PasswordValidator.class)
@Documented
public @interface Password {
    String message() default "Entry password invalid, Try again! (At least one uppercase, lowercase, number, and @, at least 8 in length)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
