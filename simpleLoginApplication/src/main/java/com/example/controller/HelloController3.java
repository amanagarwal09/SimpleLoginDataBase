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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.RegisterCompany;
import com.example.model.impl.RegisterCompanyDao;
import com.example.validator.RegisterCompanyValidator;

@Controller
public class HelloController3 {

	@Autowired
	RegisterCompanyDao dao;

	@Autowired
	RegisterCompanyValidator rcv;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(rcv);
	}

	@RequestMapping(value = "/registerCompany", method = RequestMethod.GET)
	public ModelAndView goLoginPage(Model model) {
		model.addAttribute("registercompany", new RegisterCompany());
		return new ModelAndView("/registerCompany");
	}

	@RequestMapping(value = "/registercompany", method = RequestMethod.POST)
	public ModelAndView showLoginPage(@ModelAttribute("registercompany") @Validated RegisterCompany rc,
			BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("registerCompany");
			return mv;
		}
		int insert = dao.insert(rc);
		if (insert >= 1) {
			String str = "<div class=\"alert alert-success alert-dismissible text-center\">\r\n"
					+ "			<button class=\"close\" type=\"button\" data-dismiss=\"alert\">\r\n"
					+ "				<span>&times;</span>\r\n" + "			</button>\r\n"
					+ "			<strong>Successfully</strong> Registered\r\n" + "		</div>";
			mv.addObject("msg", str);
		}
		mv.setViewName("registerCompany");
		return mv;
	}

	@RequestMapping(value = "/regComUpdate", method = RequestMethod.GET)
	public ModelAndView goUpdateCompanyPage(Model model, @RequestParam int id, @RequestParam String name,
			@RequestParam String companyname, @RequestParam long contact, @RequestParam String gender, @RequestParam String country, @RequestParam String state,
			@RequestParam String city) {
		model.addAttribute("registercompanyup", new RegisterCompany());
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("name", name);
		mv.addObject("companyname", companyname);
		if(gender.equalsIgnoreCase("Male")) {
			mv.addObject("malecheck", "");
		}else if(gender.equalsIgnoreCase("Female")) {
			mv.addObject("femalecheck", "");
		}
		mv.addObject("gender", gender);
		mv.addObject("contact", contact);
		mv.addObject("country", country);
		mv.addObject("state", state);
		mv.addObject("city", city);
		mv.setViewName("/registerCompanyUpdate");
		return mv;
	}

	@RequestMapping(value = "/regcompupdate", method = RequestMethod.POST)
	public ModelAndView showUpdateCompanyPage(@ModelAttribute("registercompanyup") @Validated RegisterCompany rc,
			BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("registerCompanyUpdate");
			return mv;
		}
		System.out.println(rc);
		int insert = dao.update(rc);
		if (insert >= 1) {
			String str = "<div class=\"alert alert-success alert-dismissible text-center\">\r\n"
					+ "			<button class=\"close\" type=\"button\" data-dismiss=\"alert\">\r\n"
					+ "				<span>&times;</span>\r\n" + "			</button>\r\n"
					+ "			<strong>Successfully</strong> Updated\r\n" + "		</div>";
			mv.addObject("msg", str);
		}
		mv.setViewName("showregcom");
		List<RegisterCompany> getall = dao.getall();
		System.out.println(getall);
		mv.addObject("getall", getall);
		return mv;
	}
	
	@RequestMapping(value = "/regComDelete", method = RequestMethod.GET)
	public ModelAndView goDeleteCompanyPage(Model model, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		model.addAttribute("registercompany", new RegisterCompany());
		int delete = dao.delete(id);
		if (delete >= 1) {
			String str = "<div class=\"alert alert-success alert-dismissible text-center\">\r\n"
					+ "			<button class=\"close\" type=\"button\" data-dismiss=\"alert\">\r\n"
					+ "				<span>&times;</span>\r\n" + "			</button>\r\n"
					+ "			<strong>Successfully</strong> Deleted\r\n" + "		</div>";
			mv.addObject("msg", str);
		}
		List<RegisterCompany> getall = dao.getall();
		System.out.println(getall);
		mv.addObject("getall", getall);
		mv.setViewName("showregcom");
		return mv;
	}
	
	@RequestMapping(value = "/showregistercompany", method = RequestMethod.GET)
	public ModelAndView showRegisterCompanyPage() {
		ModelAndView mv = new ModelAndView();
		List<RegisterCompany> getall = dao.getall();
		System.out.println(getall);
		mv.addObject("getall", getall);
		mv.setViewName("showregcom");
		return mv;
	}

}
