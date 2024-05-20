package com.ot.man.manufacturer.service;

import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerResponseDTO;

public interface ManufacturerService {
	
	ManufacturerDTO getManufacturer(Long out_nember);
	
	ManufacturerResponseDTO saveManufacturer(ManufacturerDTO manufacturerDTO);
	
	ManufacturerResponseDTO updateManufacturerStock(Long out_nember, Long out_Stock, String out_pname, boolean out_status) throws Exception;
	
	void deleteManufacturer(Long number) throws Exception;
	
//	ManufacturerDTO insertManufacturer(ManufacturerDTO manufacturerDTO);

}
