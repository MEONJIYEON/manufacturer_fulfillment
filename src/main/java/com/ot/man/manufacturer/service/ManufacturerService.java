package com.ot.man.manufacturer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ot.man.manufacturer.data.dto.MainToManufacturerDto;
import com.ot.man.manufacturer.data.dto.ManufacturerApiDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerResponseDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerToMainDto;

public interface ManufacturerService {
	
	ManufacturerDTO getManufacturer(Long out_nember);
	
	
	
	ManufacturerResponseDTO saveManufacturer(ManufacturerDTO manufacturerDTO);
	
	ManufacturerResponseDTO updateManufacturerStock(Long out_number,String out_pname,boolean out_status, Integer out_stock) throws Exception;
	
	void deleteManufacturer(Long number) throws Exception;

	List<ManufacturerDTO> getAllManufacturers();
	
	ResponseEntity<ManufacturerApiDTO> postWithBodyOnly();
//	ManufacturerDTO insertManufacturer(ManufacturerDTO manufacturerDTO);


	ManufacturerResponseDTO printManufacturer(MainToManufacturerDto mainToManufacturerDto);



	ResponseEntity<ManufacturerToMainDto> ManufacturerToMainDto(String out_productcode, String out_pname,Integer out_stock, Long out_number) throws Exception;

}
