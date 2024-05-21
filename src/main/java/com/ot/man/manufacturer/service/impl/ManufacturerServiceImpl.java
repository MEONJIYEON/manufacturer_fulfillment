package com.ot.man.manufacturer.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.man.manufacturer.data.dao.ManufacturerDAO;
import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerResponseDTO;
import com.ot.man.manufacturer.data.entity.Manufacturer;
import com.ot.man.manufacturer.service.ManufacturerService;

import lombok.Builder;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	private final ManufacturerDAO manufacturerDAO;
	
	
	@Autowired
	public ManufacturerServiceImpl(ManufacturerDAO manufacturerDAO) {
		this.manufacturerDAO = manufacturerDAO;
	}
	
	@Override
	public ManufacturerDTO getManufacturer(Long out_number) {
		Manufacturer manufacturer = manufacturerDAO.selectManufacturer(out_number);

		
		ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
		manufacturerDTO.setOut_number(manufacturer.getOut_number());
		manufacturerDTO.setOut_pname(manufacturer.getOut_pname());
		manufacturerDTO.setOut_stock(manufacturer.getOut_stock());
		manufacturerDTO.setOut_start_at(manufacturer.getOut_start_at());
		manufacturerDTO.setOut_complete_at(manufacturer.getOut_complete_at());
		manufacturerDTO.setOut_status(manufacturer.isOut_status());
		
		return manufacturerDTO;
	}
	@Override
    public List<ManufacturerDTO> getAllManufacturers() {
        List<Manufacturer> manufacturers = manufacturerDAO.selectManufacturerAll();
        return manufacturers.stream().map(manufacturer -> {
            ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
            manufacturerDTO.setOut_number(manufacturer.getOut_number());
            manufacturerDTO.setOut_pname(manufacturer.getOut_pname());
            manufacturerDTO.setOut_stock(manufacturer.getOut_stock());
            manufacturerDTO.setOut_start_at(manufacturer.getOut_start_at());
            manufacturerDTO.setOut_complete_at(manufacturer.getOut_complete_at());
            manufacturerDTO.setOut_status(manufacturer.isOut_status());
            manufacturerDTO.setOut_date(manufacturer.getOut_date());
            manufacturerDTO.setOut_history(manufacturer.getOut_history());
            return manufacturerDTO;
        }).collect(Collectors.toList());
    }

	@Override
	public ManufacturerResponseDTO saveManufacturer(ManufacturerDTO manufacturerDTO) {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setOut_pname(manufacturerDTO.getOut_pname());
		manufacturer.setOut_stock(manufacturerDTO.getOut_stock());
		manufacturer.setOut_start_at(LocalDateTime.now());
		manufacturer.setOut_complete_at(LocalDateTime.now());
		manufacturer.setOut_status(manufacturerDTO.isOut_status());
		
		 Manufacturer savedManufacturer = manufacturerDAO.insertManufacturer(manufacturer);

	        ManufacturerResponseDTO manufacturerResponseDTO = new ManufacturerResponseDTO();
	        manufacturerResponseDTO.setOut_number(savedManufacturer.getOut_number());
	        manufacturerResponseDTO.setOut_pname(savedManufacturer.getOut_pname());
	        manufacturerResponseDTO.setOut_stock(savedManufacturer.getOut_stock());
	        
			return manufacturerResponseDTO;

	        
	}

	@Override
	public ManufacturerResponseDTO updateManufacturerStock(Long out_number, Long out_stock, String out_pname, boolean out_status) throws Exception {
	
		Manufacturer updateManufacturer = manufacturerDAO.updateManufacturerStock(out_number, out_pname, out_status, out_stock);
		
		ManufacturerResponseDTO manufacturerResponseDTO = new ManufacturerResponseDTO();
		manufacturerResponseDTO.setOut_number(updateManufacturer.getOut_number());
		manufacturerResponseDTO.setOut_pname(updateManufacturer.getOut_pname());
		
		manufacturerResponseDTO.setOut_stock(updateManufacturer.getOut_stock());
		
		return manufacturerResponseDTO;
	}

	@Override
	public void deleteManufacturer(Long out_number) throws Exception {
		manufacturerDAO.deleteManufacturer(out_number);
		
		
	}

	

//	@Override
//	public ManufacturerDTO insertManufacturer(ManufacturerDTO ManufacturerDTO) {
//		Manufacturer manufacturer1 = new Manufacturer();
//		//manufacturer1.setName(ManufacturerDTO.getName()); 
//		
//		// DAO에서 받아온 타입은 Entity
//		Manufacturer manufacturer = manufacturerDAO.insertProduct(manufacturer1);
//		
//		
//		// DTO에다가 Entity를 담아준뒤 리턴 
//		ManufacturerDTO manufacturerDTOBeta = new ManufacturerDTO();
//		//manufacturerDTOBeta.setName(manufacturer.getName());
//		
//		return manufacturerDTOBeta;
//	}

}
