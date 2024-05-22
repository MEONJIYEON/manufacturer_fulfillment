package com.ot.man.admin.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ot.man.admin.controller.AdminController;
import com.ot.man.admin.data.dto.AdminLoginRequestDTO;
import com.ot.man.admin.service.AdminService;

@RestController
@RequestMapping("/manufacturer")
public class AdminControllerImpl implements AdminController {
	private final AdminService adminService;
	
	public AdminControllerImpl(AdminService adminService) {
		this.adminService = adminService;
	}

	@GetMapping("/login")
	public ModelAndView showLoginPage() {
		ModelAndView mav = new ModelAndView("/man/login");
		return mav;
	}

	@PostMapping("/loginCheck")
	public ModelAndView loginCheck(@RequestParam(value = "id", required = false, defaultValue = "") String id) {
	    ModelAndView mav = new ModelAndView();

	    AdminLoginRequestDTO loginResult = adminService.login(id);

	    if (loginResult.getId() != null) {
	        System.out.println(" success loginResult : " + loginResult);
	        mav.addObject("loginResult", loginResult);
	        // 로그인 성공 시 /manufacturer/all로 리다이렉트
	        mav.setViewName("redirect:/manufacturer/all");
	    } else {
	        System.out.println(" fail loginResult : " + loginResult);
	        mav.setViewName("fail");
	    }

	    return mav;
	}


}