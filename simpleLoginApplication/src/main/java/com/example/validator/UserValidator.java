package com.example.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.example.model.Login;

@Component
public class UserValidator implements org.springframework.validation.Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Login.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "email", "login.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "login.password.empty");
		
		Login login = (Login) target;
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(login.getEmail()).matches())) {
			errors.rejectValue("email", "login.email.invalid");
		}
		
		Pattern pattern2 = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}");
		if (!(pattern2.matcher(login.getPassword()).matches())) {
			errors.rejectValue("password", "login.password.invalid");
		}
	}
}
