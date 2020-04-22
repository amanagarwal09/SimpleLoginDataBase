package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Login;
import com.example.model.Register;
import com.example.model.impl.RegisterDao;
import com.example.validator.RegisterValidator;
import com.example.validator.UserValidator;

@Controller
public class HelloController {

	@Autowired
	RegisterDao dao;
	@Autowired
	private RegisterValidator regVal;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(regVal);
	}

	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public ModelAndView goRegisterPage(Model model) {
		model.addAttribute("register", new Register());
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/submitRegister", method = RequestMethod.POST)
	public ModelAndView showRegisterPage(@ModelAttribute("register") @Validated Register register,
			BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("register");
			return mv;
		}
		List<Register> getall = dao.getall();
		for (Register i : getall) {
			if (i.getEmail().equals(register.getEmail())) {
				String str = "<div class=\"alert alert-danger alert-dismissible text-center\">\r\n"
						+ "			<button class=\"close\" type=\"button\" data-dismiss=\"alert\">\r\n"
						+ "				<span>&times;</span>\r\n" + "			</button>\r\n"
						+ "			<strong>User Already Registed</strong> with this Email-ID\r\n" + "		</div>";
				mv.addObject("sameEmail", str);
				mv.setViewName("register");
				return mv;
			}
		}
		int insert = dao.insert(register);
		if (insert >= 1) {
			String str = "<div class=\"alert alert-success alert-dismissible text-center\">\r\n"
					+ "			<button class=\"close\" type=\"button\" data-dismiss=\"alert\">\r\n"
					+ "				<span>&times;</span>\r\n" + "			</button>\r\n"
					+ "			<strong>Registration Successful!</strong> Now Try To Login\r\n" + "		</div>";
			mv.addObject("nowlogin", str);
			mv.setViewName("register");
			return mv;
		} else {
			mv.setViewName("register");
			return mv;
		}
	}
	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public ModelAndView showAll() {
		ModelAndView mv = new ModelAndView();
		List<Register> getall = dao.getall();
		mv.addObject("list", getall);
		if(getall.size()==0) {
			String str = "<tr>\r\n" + 
					"				<td colspan=\"5\">No Data Available\r\n" + 
					"				</td>\r\n" + 
					"			</tr>";
			mv.addObject("nothing", str);
		}
		mv.setViewName("showall");
		return mv;
	}
}
