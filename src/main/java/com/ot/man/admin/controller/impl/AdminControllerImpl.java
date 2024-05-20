package com.ot.man.admin.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ot.man.admin.controller.AdminController;

@Controller
public class AdminControllerImpl implements AdminController {

    @Override
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}