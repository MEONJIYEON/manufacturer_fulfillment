package com.ot.man.manufacturer.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ot.man.manufacturer.data.dao.ManufacturerDAO;
import com.ot.man.manufacturer.data.dto.MainToManufacturerDto;
import com.ot.man.manufacturer.data.dto.ManufacturerApiDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerResponseDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerToMainDto;
import com.ot.man.manufacturer.data.entity.Manufacturer;
import com.ot.man.manufacturer.service.ManufacturerService;

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
            manufacturerDTO.setOut_productcode(manufacturer.getOut_productcode());
            return manufacturerDTO;
        }).collect(Collectors.toList());
    }

	@Override
	public ManufacturerResponseDTO saveManufacturer(ManufacturerDTO manufacturerDTO) {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setOut_pname(manufacturerDTO.getOut_pname());
		manufacturer.setOut_stock(manufacturerDTO.getOut_stock());
		manufacturer.setOut_productcode(manufacturerDTO.getOut_productcode());
		manufacturer.setOut_start_at(LocalDateTime.now());
		manufacturer.setOut_complete_at(LocalDateTime.now());
		manufacturer.setOut_status(manufacturerDTO.isOut_status());
		
		 Manufacturer savedManufacturer = manufacturerDAO.insertManufacturer(manufacturer);

	        ManufacturerResponseDTO manufacturerResponseDTO = new ManufacturerResponseDTO();
	        manufacturerResponseDTO.setOut_number(savedManufacturer.getOut_number());
	        manufacturerResponseDTO.setOut_pname(savedManufacturer.getOut_pname());
	        manufacturerResponseDTO.setOut_stock(savedManufacturer.getOut_stock());
	        manufacturerResponseDTO.setOut_productcode(savedManufacturer.getOut_productcode());
	  
	        
			return manufacturerResponseDTO;

	        
	}
	@Override
	public ManufacturerResponseDTO printManufacturer(MainToManufacturerDto mainToManufacturerDto) {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setOut_pname(mainToManufacturerDto.getOut_pname());
		manufacturer.setOut_stock(mainToManufacturerDto.getOut_stock());
		manufacturer.setOut_productcode(mainToManufacturerDto.getOut_productcode());
		manufacturer.setOut_start_at(LocalDateTime.now());
		manufacturer.setOut_complete_at(LocalDateTime.now());
		manufacturer.setOut_status(false);
		
		 Manufacturer printedManufacturer = manufacturerDAO.insertManufacturer(manufacturer);

	        ManufacturerResponseDTO manufacturerResponseDTO = new ManufacturerResponseDTO();
	        manufacturerResponseDTO.setOut_number(printedManufacturer.getOut_number());
	        manufacturerResponseDTO.setOut_pname(printedManufacturer.getOut_pname());
	        manufacturerResponseDTO.setOut_stock(printedManufacturer.getOut_stock());
	        manufacturerResponseDTO.setOut_productcode(printedManufacturer.getOut_productcode());
	  
	        
			return manufacturerResponseDTO;
	}
	
	
	@Override
	public ManufacturerResponseDTO updateManufacturerStock(Long out_number,String out_pname,boolean out_status, Integer out_stock) throws Exception {
	
		Manufacturer updateManufacturer = manufacturerDAO.updateManufacturerStock(out_number, out_pname,out_status, out_stock);
		
		ManufacturerResponseDTO manufacturerResponseDTO = new ManufacturerResponseDTO();
		manufacturerResponseDTO.setOut_number(updateManufacturer.getOut_number());
		manufacturerResponseDTO.setOut_pname(updateManufacturer.getOut_pname());
		//수정
		manufacturerResponseDTO.setOut_status(updateManufacturer.isOut_status());
		manufacturerResponseDTO.setOut_stock(updateManufacturer.getOut_stock());
		
		return manufacturerResponseDTO;
	}

	@Override
	public void deleteManufacturer(Long out_number) throws Exception {
		manufacturerDAO.deleteManufacturer(out_number);
		
		
	}

	@Override
	public ResponseEntity<ManufacturerApiDTO> postWithBodyOnly() {
	    WebClient webClient = WebClient.builder()
	            .baseUrl("http://localhost:9001")
	            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	            .build();

	    ManufacturerApiDTO manufacturerApiDTO = new ManufacturerApiDTO();
	    manufacturerApiDTO.setOut_pname("testname");
	    manufacturerApiDTO.setOut_stock(100);

	    return webClient.post()
	            .uri("/api/v1/crud-api")
	            .bodyValue(manufacturerApiDTO)
	            .retrieve()
	            .toEntity(ManufacturerApiDTO.class)
	            .block();
	}

	@Override
	public ResponseEntity<ManufacturerToMainDto> ManufacturerToMainDto( String out_productcode, String out_pname, Integer out_stock, Long out_number) throws Exception {
		WebClient webClient = WebClient.builder()
	               .baseUrl("http://localhost:9001")
	               .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	               .build();

		  manufacturerDAO.updateStatusById(out_number);
	       ManufacturerToMainDto manufacturerToMainDto = new ManufacturerToMainDto();
	       manufacturerToMainDto.setOut_pname(out_productcode);
	       manufacturerToMainDto.setOut_productcode(out_pname);
	       manufacturerToMainDto.setOut_stock(out_stock);
	     
	       
	       return webClient.post()
	               .uri("/api/v1/main-fulfillment/in/manufacturerToMain")
	               .bodyValue(manufacturerToMainDto)
	               .retrieve()
	               .toEntity(ManufacturerToMainDto.class)
	               .block();
	       
	      
	   }

	
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
	

