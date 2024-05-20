package com.ot.man.admin.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ot.man.admin.controller.AdminController;
import com.ot.man.admin.data.entity.Admin;
import com.ot.man.admin.service.AdminService;

@Controller
public class AdminControllerImpl implements AdminController {
	 private final AdminService adminService;
	 
	 @Autowired
	    public AdminControllerImpl(AdminService adminService) {
	        this.adminService = adminService;
	    }
    @Override
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(String id, String pw, HttpSession session, Model model) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null && admin.getPw().equals(pw)) {
            session.setAttribute("admin", admin);
            return "redirect:/admin";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}