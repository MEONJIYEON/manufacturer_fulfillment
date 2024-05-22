package com.ot.man.admin.controller;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminController {
	public ModelAndView showLoginPage();
	public ModelAndView loginCheck(@RequestParam String id);

}
