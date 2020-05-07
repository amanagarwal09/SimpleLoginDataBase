package com.example.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.example.model.RegisterCompany;

@Component
public class RegisterCompanyValidator implements org.springframework.validation.Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterCompany.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "registercomp.name.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyname", "registercomp.companyname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "registercomp.contact.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "registercomp.gender.empty");
		
		RegisterCompany rc = (RegisterCompany) target;
		long contact = rc.getContact();
		String string = Long.toString(contact);
		if(!string.matches("[7-9]{1}[0-9]{9}")) {
			errors.rejectValue("contact", "registercomp.contact.invalid");
		}
		if(rc.getContact()==0) {
			errors.rejectValue("contact", "registercomp.contact.empty");
		}
		if(rc.getCountry().equalsIgnoreCase("Choose")) {
			errors.rejectValue("country", "registercomp.country.empty");
		}
		if(rc.getCountry().equalsIgnoreCase("Choose")) {
			errors.rejectValue("state", "registercomp.state.empty");
		}
		if(rc.getCountry().equalsIgnoreCase("Choose")) {
			errors.rejectValue("city", "registercomp.city.empty");
		}
	}
}
