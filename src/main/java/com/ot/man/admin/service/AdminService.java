package com.ot.man.admin.service;

import com.ot.man.admin.data.dto.AdminLoginRequestDTO;

public interface AdminService {
	AdminLoginRequestDTO login(String id);
}
