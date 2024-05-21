package com.ot.man.manufacturer.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.man.manufacturer.controller.ManufacturerController;
import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerResponseDTO;
import com.ot.man.manufacturer.data.dto.UpdateManufacturerStockDTO;
import com.ot.man.manufacturer.service.ManufacturerService;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerControllerImpl implements ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerControllerImpl(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

	

	@GetMapping("/{id}")
	public ResponseEntity<ManufacturerDTO> getManufacturer(Long out_number) {
		 ManufacturerDTO manufacturerResponseDTO = manufacturerService.getManufacturer(out_number);
			return  ResponseEntity.status(HttpStatus.OK).body(manufacturerResponseDTO);
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<ManufacturerDTO>> getAllManufacturers() {
        List<ManufacturerDTO> manufacturers = manufacturerService.getAllManufacturers();
        return ResponseEntity.status(HttpStatus.OK).body(manufacturers);
    }
	
	@PostMapping()
	public ResponseEntity<ManufacturerResponseDTO> createManufacturer(@RequestBody ManufacturerDTO manufacturerDTO){
		ManufacturerResponseDTO manufacturerResponseDTO= manufacturerService.saveManufacturer(manufacturerDTO);
		
		return ResponseEntity.status(HttpStatus.OK).body(manufacturerResponseDTO);
	}
	
	@PutMapping()
	public ResponseEntity<ManufacturerResponseDTO> updateManufacturerStock(
			@RequestBody UpdateManufacturerStockDTO updateManufacturerStockDTO) throws Exception{
		ManufacturerResponseDTO manufacturerResponseDTO = manufacturerService.updateManufacturerStock(
				updateManufacturerStockDTO.getOut_number(),
				updateManufacturerStockDTO.getOut_number(),
				updateManufacturerStockDTO.getOut_pname(),
				updateManufacturerStockDTO.isOut_status()
				);
		return ResponseEntity.status(HttpStatus.OK).body(manufacturerResponseDTO);
	}
	
	@DeleteMapping
	public ResponseEntity<String>deleteManufacturer(Long out_number) throws Exception{
		manufacturerService.deleteManufacturer(out_number);
		
		return ResponseEntity.status(HttpStatus.OK).body("삭제완료");
	}

	
	
	

//	@Override
//	@PostMapping()
//	public ResponseEntity<ManufacturerDTO> insertManufacturer(ManufacturerDTO manufacturerDTO) {
//		ManufacturerDTO manufacturerDTOBeta = manufacturerService.insertManufacturer(manufacturerDTO);
//		
//		
//		return null;
//	}
//	
	
	
	
	
	



	
}