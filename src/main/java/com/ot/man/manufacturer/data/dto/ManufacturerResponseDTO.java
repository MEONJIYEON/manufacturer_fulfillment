package com.ot.man.manufacturer.data.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerResponseDTO {
	 private long out_number;
	 private String out_pname;
	 private Integer out_stock;
	 private boolean out_status;
	 private String out_productcode;
	   
}
