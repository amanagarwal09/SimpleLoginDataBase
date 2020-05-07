package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Login;
import com.example.model.Register;
import com.example.model.impl.RegisterDao;
import com.example.validator.UserValidator;

@Controller
public class HelloController2 {

	@Autowired
	RegisterDao dao;

	@Autowired
	private UserValidator userVal;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userVal);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView goLoginPage(Model model) {
		model.addAttribute("login", new Login());
		return new ModelAndView("loginPage");
	}

	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public ModelAndView showLoginPage(@ModelAttribute("login") @Validated Login model, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()){
			mv.setViewName("loginPage");
			return mv;
		}
		List<Register> getall = dao.getall();
		for (Register i : getall) {
			if (i.getEmail().equals(model.getEmail()) && i.getPassword().equals(model.getPassword())) {
				System.out.println(model);
				Register byEmail = dao.getByEmail(model.getEmail());
				String name = byEmail.getName();
				mv.addObject("name", name);
				mv.setViewName("success");
				return mv;
			}
		}
		String str = "<div class=\"alert alert-warning alert-dismissible text-center\">\r\n" + 
				"			<button class=\"close\" type=\"button\" data-dismiss=\"alert\">\r\n" + 
				"				<span>&times;</span>\r\n" + 
				"			</button>\r\n" + 
				"			<strong>Wrong</strong> Credential or <strong>Register</strong> First\r\n" + 
				"		</div>";
		mv.addObject("loginfailed", str);
		mv.setViewName("loginPage");
		return mv;
	}

}
