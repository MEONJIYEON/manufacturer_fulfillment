package com.ot.man.manufacturer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ot.man.manufacturer.data.dto.ManufacturerApiDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerResponseDTO;

public interface ManufacturerService {
	
	ManufacturerDTO getManufacturer(Long out_nember);
	
	ManufacturerResponseDTO saveManufacturer(ManufacturerDTO manufacturerDTO);
	
	ManufacturerResponseDTO updateManufacturerStock(Long out_number,String out_pname, boolean out_status,  Long out_stock) throws Exception;
	
	void deleteManufacturer(Long number) throws Exception;

	List<ManufacturerDTO> getAllManufacturers();
	
	ResponseEntity<ManufacturerApiDTO> postWithBodyOnly();
//	ManufacturerDTO insertManufacturer(ManufacturerDTO manufacturerDTO);

}
