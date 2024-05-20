package com.ot.man.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface AdminController {
	@GetMapping("/admin")
    String admin();
}
