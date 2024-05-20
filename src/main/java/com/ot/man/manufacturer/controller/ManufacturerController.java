package com.ot.man.manufacturer.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerResponseDTO;


public interface ManufacturerController {

	  ResponseEntity<ManufacturerDTO> getManufacturer(Long out_number);
//	  ResponseEntity(ManufacturerResponseDTO) get
//	  ResponseEntity<ManufacturerDTO> insertManufacturer(@RequestBody ManufacturerDTO manufacturerDTO);
	
}