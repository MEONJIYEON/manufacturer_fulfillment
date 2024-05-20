package com.ot.man.manufacturer.data.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerDTO {
	private long out_number;
    private String out_pname;
    private long out_stock;
    private LocalDateTime out_start_at;
    private LocalDateTime out_complete_at;
    private boolean out_status;
    private LocalDateTime out_date;
}
