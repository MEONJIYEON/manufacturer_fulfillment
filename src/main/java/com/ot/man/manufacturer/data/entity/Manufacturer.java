package com.ot.man.manufacturer.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "M_O_Manufacturer")
public class Manufacturer {
	
	

	//출고번호 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "out_number_seq")
	@SequenceGenerator(name = "out_number_seq", sequenceName = "OUT_NUMBER_SEQ", allocationSize = 1)
	private long out_number; 
	
	 // 상품명
	@Column(nullable = false)
	private String out_pname;
	
	
	// 출고 개수
	@Column(nullable = false)
	private Integer out_stock; 
	
	//출고 시작(출고 중) 날짜 (현재 시간으로 초기화)
	private LocalDateTime out_start_at;
	
	//출고 완료 날짜
	private LocalDateTime out_complete_at;
	
	// 출고 처리 내역 : T : 촐고 완료 , F: 출고 중 
	@Column(nullable = false)
	private boolean out_status; 
	
	@Column(nullable = false)
	 private LocalDateTime out_date;
	
	  @Column(nullable = false)
	    private int out_history; 
	
	  @Column
		private String out_productcode;
	  
	@PrePersist
    protected void onCreate() {
        out_start_at = LocalDateTime.now();
        if (out_date == null) {
            out_date = LocalDateTime.now();  
        }
        if (out_history == 0) {
            out_history = 1;
        }
    }
	
}