package com.ot.man.manufacturer.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateManufacturerStockDTO {
	private Long out_number;
	private Integer out_stock;
	private String out_pname;
	private boolean out_status;
}
