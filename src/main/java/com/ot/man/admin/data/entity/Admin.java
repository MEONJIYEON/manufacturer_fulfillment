package com.ot.man.admin.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name= "M_O_Admin")
public class Admin {
	
	@Id
	@Column(nullable = false, unique = true)
	private String id;
	
	@Column(nullable = false)
	private String pw;

}
