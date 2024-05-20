package com.ot.man.manufacturer.data.dao;

import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.entity.Manufacturer;

public interface ManufacturerDAO {
	Manufacturer insertManufacturer(Manufacturer manufacturer);
	
	Manufacturer selectManufacturer(Long out_number );
	
	Manufacturer updateManufacturerStock(Long out_number, String out_pname, boolean out_status , Long out_stock) throws Exception;
	
	void deleteManufacturer(Long out_number) throws Exception;
	
//	Manufacturer insertProduct(Manufacturer manufacturer);
}
