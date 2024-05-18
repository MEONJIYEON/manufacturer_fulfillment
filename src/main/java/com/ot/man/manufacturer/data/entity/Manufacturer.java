package com.ot.man.manufacturer.data.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name= "M_O_Manufacturer")
public class Manufacturer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "out_number_seq")
	@SequenceGenerator(name = "out_number_seq", sequenceName = "OUT_NUMBER_SEQ", allocationSize = 1)
	@Column(nullable = false, unique = true)
	private long out_number; //출고번호 
	
	@Column(nullable = false)
	private String out_pname; // 상품명
	
	@Column(nullable = false)
	private long out_stock; // 출고 개수
	
	@Column(nullable = false)
	private LocalDateTime out_date = LocalDateTime.now(); // 출고 날짜 (현재 시간으로 초기화)
	
	@Column(nullable = false)
	private boolean out_history; // 출고 처리 내역 
}