package com.ot.man.admin.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "M_O_ADMIN")
public class Admin {
	@Id
	private String id;
	
	@Column(nullable = false)
	private String pw;
}