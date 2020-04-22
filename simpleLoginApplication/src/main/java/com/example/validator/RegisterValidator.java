package com.example.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.example.model.Register;

@Component
public class RegisterValidator implements org.springframework.validation.Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Register.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userid", "register.userId.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "register.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "register.password.empty");
		
		Register register = (Register) target;
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(register.getEmail()).matches())) {
			errors.rejectValue("email", "register.email.invalid");
		}
		
		Pattern pattern2 = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}");
		if (!(pattern2.matcher(register.getPassword()).matches())) {
			errors.rejectValue("password", "register.password.invalid");
		}
		
		Pattern pattern3 = Pattern.compile("[a-zA-Z ]{2,}");
		if (!(pattern3.matcher(register.getuserid()).matches())) {
			errors.rejectValue("userid", "register.userid.invalid");
		}
	}
}
