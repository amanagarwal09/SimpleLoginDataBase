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
		}
}
