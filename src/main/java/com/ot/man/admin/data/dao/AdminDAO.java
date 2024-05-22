package com.ot.man.admin.data.dao;

import com.ot.man.admin.data.dto.AdminLoginRequestDTO;

public interface AdminDAO {
	
	//로그인
	AdminLoginRequestDTO login(String id);
	
}
