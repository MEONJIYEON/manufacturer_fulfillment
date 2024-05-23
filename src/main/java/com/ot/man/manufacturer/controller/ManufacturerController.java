package com.ot.man.manufacturer.controller;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerResponseDTO;
import com.ot.man.manufacturer.data.dto.UpdateManufacturerStockDTO;


public interface ManufacturerController {

	  ModelAndView getManufacturer(Long out_number);
	 
//	  ResponseEntity(ManufacturerResponseDTO) get
//	  ResponseEntity<ManufacturerDTO> insertManufacturer(@RequestBody ManufacturerDTO manufacturerDTO);
	  
	 //ResponseEntity<ManufacturerResponseDTO> updateManufacturerStock(@RequestBody UpdateManufacturerStockDTO updateManufacturerStockDTO) throws Exception;
	 
	  ModelAndView index();
}