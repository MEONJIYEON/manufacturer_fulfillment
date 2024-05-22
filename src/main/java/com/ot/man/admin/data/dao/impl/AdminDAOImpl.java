package com.ot.man.admin.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ot.man.admin.data.dao.AdminDAO;
import com.ot.man.admin.data.dto.AdminLoginRequestDTO;
import com.ot.man.admin.data.entity.Admin;
import com.ot.man.admin.data.repository.AdminRepository;

@Component
public class AdminDAOImpl implements AdminDAO {
	private final AdminRepository adminRepository;
	
	@Autowired
	public AdminDAOImpl(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public AdminLoginRequestDTO login(String id) {
		AdminLoginRequestDTO adminRequestDto = new AdminLoginRequestDTO();
		
		Boolean existLogin = adminRepository.existsById(id);
		
		if(existLogin == true) {
			Admin loginInformation = adminRepository.findById(id).get();
			adminRequestDto.setId(loginInformation.getId());
			adminRequestDto.setPw(loginInformation.getPw());
		}
		return adminRequestDto;
	}

}