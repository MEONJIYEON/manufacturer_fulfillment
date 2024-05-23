package com.ot.man.manufacturer.data.dao;

import java.util.List;

import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.entity.Manufacturer;

public interface ManufacturerDAO {
	Manufacturer insertManufacturer(Manufacturer manufacturer);
	
	Manufacturer selectManufacturer(Long out_number );
	
	List<Manufacturer> selectManufacturerAll();
	
	Manufacturer updateManufacturerStock(Long out_number, String out_pname, boolean out_status , Integer out_stock) throws Exception;
	
	void deleteManufacturer(Long out_number) throws Exception;

	void updateStatusById(Long out_number) throws Exception;
	
	
	
//	Manufacturer insertProduct(Manufacturer manufacturer);
}
