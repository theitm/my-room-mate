package motelRoom.service.customAnnotaion;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return phoneNumber != null && phoneNumber.matches("0[0-9]{9}") && phoneNumber.length() > 8 && phoneNumber.length() < 11;
    }
}
