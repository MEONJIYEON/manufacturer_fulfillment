package com.ot.man.manufacturer.data.dao.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ot.man.manufacturer.data.dao.ManufacturerDAO;

import com.ot.man.manufacturer.data.entity.Manufacturer;
import com.ot.man.manufacturer.data.repository.ManufacturerRepository;

@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO {
	
	private final ManufacturerRepository manufacturerRepository;

	@Autowired
	public ManufacturerDAOImpl(ManufacturerRepository manufacturerRepository){
	    this.manufacturerRepository = manufacturerRepository;
	}
	
//	@Autowired
//	private ManufacturerRepository manufacturerRepository;

	@Override
	public Manufacturer insertManufacturer(Manufacturer manufacturer) {
		Manufacturer saveManufacturer = manufacturerRepository.save(manufacturer);
		return saveManufacturer;
	}

	@Override
	public Manufacturer selectManufacturer(Long out_number) {
		Manufacturer selectManufacturer = manufacturerRepository.getById(out_number);
		return selectManufacturer;
	}

	@Override
	@Transactional
	public Manufacturer updateManufacturerStock(Long out_number, String out_pname, boolean out_status, Integer out_stock) throws Exception  {
		Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(out_number);
		
		if (!optionalManufacturer.isPresent()) {
			throw new Exception("Manufacturer not found");
		}

		Manufacturer manufacturer = optionalManufacturer.get();
		manufacturer.setOut_pname(out_pname);
		manufacturer.setOut_status(out_status);
		manufacturer.setOut_stock(out_stock);
		manufacturer.setOut_status(true);

		if (out_status) {
			manufacturer.setOut_complete_at(LocalDateTime.now());
		} else {
			manufacturer.setOut_complete_at(null);
		}

		return manufacturerRepository.save(manufacturer);
	}
	

	
	@Override
	@Transactional
	public void deleteManufacturer(Long out_number) throws Exception {
		Optional<Manufacturer>selectManufacturer = manufacturerRepository.findById(out_number);
		
		if(selectManufacturer.isPresent()) {
			Manufacturer manufacturer = selectManufacturer.get();
			
			manufacturerRepository.delete(manufacturer);
		}else {
			throw new Exception();
		}
		
	}

	@Override
	public List<Manufacturer> selectManufacturerAll() {
		 return manufacturerRepository.findAll();
	
	}
	 @Override
	    @Transactional
	    public void updateStatusById(Long out_number) throws Exception {
		 Optional<Manufacturer> optionalManufacturer= manufacturerRepository.findById(out_number);
		 
		 if (!optionalManufacturer.isPresent()) {
				throw new Exception("Manufacturer not found");
			}
		 Manufacturer manufacturer = optionalManufacturer.get();
	        manufacturer.setOut_status(true);
	        manufacturer.setOut_complete_at(LocalDateTime.now());
	        manufacturerRepository.save(manufacturer);
	    }


//	@Override
//	public Manufacturer insertProduct(Manufacturer manufacturer) {
//		Manufacturer manufacturer1 =manufacturerRepository.save(manufacturer);
//		return manufacturer1;
//	}

	
}
