package com.ot.man.manufacturer.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerApiDTO {
	private String out_pname;
	private Integer out_stock;
}
