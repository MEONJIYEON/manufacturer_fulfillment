package com.ot.man.manufacturer.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ot.man.manufacturer.controller.ManufacturerController;
import com.ot.man.manufacturer.data.dto.MainToManufacturerDto;
import com.ot.man.manufacturer.data.dto.ManufacturerDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerResponseDTO;
import com.ot.man.manufacturer.data.dto.ManufacturerToMainDto;
import com.ot.man.manufacturer.service.ManufacturerService;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerControllerImpl implements ManufacturerController {

	private final ManufacturerService manufacturerService;

	@Autowired
	public ManufacturerControllerImpl(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}

//	@GetMapping("/{out_number}")
//	public ResponseEntity<ManufacturerDTO> getManufacturer(@PathVariable("out_number")Long out_number) {
//		 ManufacturerDTO manufacturerResponseDTO = manufacturerService.getManufacturer(out_number);
//			return  ResponseEntity.status(HttpStatus.OK).body(manufacturerResponseDTO);
//	}
//	

	@GetMapping("/{out_number}")
	public ModelAndView getManufacturer(@PathVariable("out_number") Long out_number) {
		ManufacturerDTO manufacturerResponseDTO = manufacturerService.getManufacturer(out_number);
		ModelAndView mav = new ModelAndView("manufacturer");
		mav.addObject("manufacturer", manufacturerResponseDTO);
		return mav;
	}

	

//	@GetMapping("/all")
//    public ResponseEntity<List<ManufacturerDTO>> getAllManufacturers() {
//        List<ManufacturerDTO> manufacturers = manufacturerService.getAllManufacturers();
//        return ResponseEntity.status(HttpStatus.OK).body(manufacturers);
//    }
//	
	@GetMapping("/all")
	public ModelAndView getAllManufacturers() {
		List<ManufacturerDTO> manufacturers = manufacturerService.getAllManufacturers();
		ModelAndView mav = new ModelAndView("/man/manufacturer_read");
		mav.addObject("manufacturers", manufacturers);
		return mav;
	}

//	@PostMapping()
//	public ResponseEntity<ManufacturerResponseDTO> createManufacturer(@RequestBody ManufacturerDTO manufacturerDTO){
//		ManufacturerResponseDTO manufacturerResponseDTO= manufacturerService.saveManufacturer(manufacturerDTO);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(manufacturerResponseDTO);
//	}
//	
	/*
	 * @PostMapping("/insert") public ModelAndView
	 * insertManufacturer(@RequestParam("out_stock") String out_stock,
	 * 
	 * @RequestParam("out_pname") String out_pname, RedirectAttributes
	 * redirectAttributes) { ManufacturerDTO manufacturerDTO = new
	 * ManufacturerDTO(); manufacturerDTO.setOut_stock(Long.parseLong(out_stock));
	 * manufacturerDTO.setOut_pname(out_pname);
	 * 
	 * manufacturerService.saveManufacturer(manufacturerDTO);
	 * 
	 * // ModelAndView mav = new ModelAndView("redirect:/manufacturer_read/all");
	 * ModelAndView mav = new ModelAndView("/man/manufacturer_create");
	 * 
	 * return mav; }
	 */

	@PostMapping("/insert")
	public ModelAndView insertManufacturer(@RequestParam("out_stock") String out_stock,
			@RequestParam("out_pname") String out_pname, @RequestParam("out_productcode") String out_productcode,RedirectAttributes redirectAttributes) {
		ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
		manufacturerDTO.setOut_stock(Integer.parseInt(out_stock));
		manufacturerDTO.setOut_pname(out_pname);
		manufacturerDTO.setOut_productcode(out_productcode);

		manufacturerService.saveManufacturer(manufacturerDTO);
//        redirectAttributes.addFlashAttribute("message", "Manufacturer created successfully!");
		ModelAndView mav = new ModelAndView("redirect:/manufacturer/all");
		return mav;
	}

	@GetMapping("/insertpage")
	public ModelAndView showCreateForm() {
		return new ModelAndView("/man/manufacturer_create");
	}

	/*
	 * @PutMapping() public ResponseEntity<ManufacturerResponseDTO>
	 * updateManufacturerStock(
	 * 
	 * @RequestBody UpdateManufacturerStockDTO updateManufacturerStockDTO) throws
	 * Exception{ //Long out_number,String out_pname, boolean out_status, Long
	 * out_stock ManufacturerResponseDTO manufacturerResponseDTO =
	 * manufacturerService.updateManufacturerStock(
	 * updateManufacturerStockDTO.getOut_number(),
	 * updateManufacturerStockDTO.getOut_pname(),
	 * updateManufacturerStockDTO.isOut_status(),
	 * updateManufacturerStockDTO.getOut_stock() ); return
	 * ResponseEntity.status(HttpStatus.OK).body(manufacturerResponseDTO); }
	 */

	/*
	 * @PostMapping("/update") public ModelAndView
	 * updateManufacturerStock(@RequestBody UpdateManufacturerStockDTO
	 * updateManufacturerStockDTO, RedirectAttributes redirectAttributes) throws
	 * Exception { ManufacturerResponseDTO manufacturerResponseDTO =
	 * manufacturerService.updateManufacturerStock(
	 * updateManufacturerStockDTO.getOut_number(),
	 * updateManufacturerStockDTO.getOut_pname(),
	 * updateManufacturerStockDTO.isOut_status(),
	 * updateManufacturerStockDTO.getOut_stock() );
	 * 
	 * 
	 * manufacturerService.updateManufacturerStock(updateManufacturerStockDTO.
	 * getOut_number(), updateManufacturerStockDTO.getOut_pname(),
	 * updateManufacturerStockDTO.isOut_status(),
	 * updateManufacturerStockDTO.getOut_stock());
	 * 
	 * ModelAndView mav = new ModelAndView("redirect:/manufacturer/all");
	 * mav.addObject("manufacturer", manufacturerResponseDTO); return mav; }
	 * 
	 */
	@PostMapping("/update")
	public ModelAndView updateManufacturerStock(@RequestParam("out_number") Long out_number,
			@RequestParam("out_pname") String out_pname, @RequestParam("out_status") boolean out_status,
			@RequestParam("out_stock") Integer out_stock, RedirectAttributes redirectAttributes) throws Exception {
		manufacturerService.updateManufacturerStock(out_number, out_pname, out_status, out_stock);

		ModelAndView mav = new ModelAndView("redirect:/manufacturer/all");

		return mav;
	}

//	@GetMapping("/updatepage")
//	public ModelAndView showUpdateForm(@RequestParam("out_number") String out_number,
//			@RequestParam("out_pname") String out_pname, 
//			@RequestParam("out_stock")String out_stock) {
//		System.out.println(out_number);
//		System.out.println(out_pname);
//		System.out.println(out_stock);
//		ModelAndView mav = new ModelAndView("/man/manufacturer_update");
//		mav.addObject("out_number", out_number);
//		mav.addObject("out_pname", out_pname);
//		mav.addObject("out_stock", out_stock);
//		return mav;
//	}
	
	@GetMapping("/updatepage")
	public ModelAndView showUpdateForm(@RequestParam("out_number")String out_number,
			@RequestParam("out_pname") String out_pname, 
			@RequestParam("out_stock")String out_stock) {
		System.out.println(out_number);
		System.out.println(out_pname);
		System.out.println(out_stock);
		ModelAndView mav = new ModelAndView("/man/manufacturer_update");
		mav.addObject("out_number", out_number);
		mav.addObject("out_pname", out_pname);
		mav.addObject("out_stock", out_stock);
		return mav;
	}
	/*
	 * @DeleteMapping("/{out_number}") public
	 * ResponseEntity<String>deleteManufacturer(@PathVariable("out_number")Long
	 * out_number) throws Exception{
	 * manufacturerService.deleteManufacturer(out_number);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body("삭제완료"); } /
	 */

//*
	@PostMapping("/delete")
	public ModelAndView deleteManufacturer(@RequestParam("out_number") String out_number,
			RedirectAttributes redirectAttributes) throws Exception {
		manufacturerService.deleteManufacturer(Long.parseLong(out_number));
		ModelAndView mav = new ModelAndView("redirect:/manufacturer/all");

		return mav;
	}
	// */

//	@Override
//	@PostMapping()
//	public ResponseEntity<ManufacturerDTO> insertManufacturer(ManufacturerDTO manufacturerDTO) {
//		ManufacturerDTO manufacturerDTOBeta = manufacturerService.insertManufacturer(manufacturerDTO);
//		
//		
//		return null;
//	}
	
	// WebClient 통신 제조사 -> 메인 요청
	   @PostMapping("/manufacturerToMain")
	   public ResponseEntity<ManufacturerToMainDto> manufacturerToMainDto(@RequestParam String out_productcode,@RequestParam String out_pname, @RequestParam Integer out_stock, @RequestParam Long out_number) throws Exception {
		   
	      return manufacturerService.ManufacturerToMainDto(out_productcode, out_pname, out_stock, out_number);
	   }
	   
//	@PostMapping("/manufacturerToMain")
//	   public ResponseEntity<ManufacturerToMainDto> manufacturerToMainDto(@RequestParam String out_productcode,@RequestParam String out_pname, @RequestParam Integer out_stock, @RequestParam Long out_number) throws Exception {
//		 ManufacturerResponseDTO manufacturerResponseDTO = manufacturerService.printManufacturer(manufacturerToMainDto);
//	      return manufacturerService.ManufacturerToMainDto(out_productcode, out_pname, out_stock, out_number);
//	   }
//	@PostMapping("/manufacturerToMain")
//	public ResponseEntity<ManufacturerResponseDTO> manufacturerToMainDto(@RequestBody MainToManufacturerDto mainToManufacturerDto) {
//	    System.out.println(mainToManufacturerDto);
//
//	    ManufacturerResponseDTO manufacturerResponseDTO = manufacturerService.printManufacturer(mainToManufacturerDto);
//
//	    return ResponseEntity.status(HttpStatus.OK).body(manufacturerResponseDTO);
//	}
//	
//	@PostMapping("/mainToManufacturer")
//	public ResponseEntity<ManufacturerToMainDto> mainToManufacturer(@RequestParam String out_productcode, @RequestParam String out_pname, @RequestParam Integer out_stock, @RequestParam Long out_number) throws Exception {
//	    return manufacturerService.ManufacturerToMainDto(out_productcode, out_pname, out_stock, out_number);
//	}


	   
	   
	   // WebClient 통신 메인 -> 제조사 응답
	   @PostMapping("/mainToManufacturer")
	   public ResponseEntity<ManufacturerResponseDTO> mainToManufacturer(@RequestBody MainToManufacturerDto mainToManufacturerDto ){
	      System.out.println(mainToManufacturerDto);
	      
	      
	      ManufacturerResponseDTO manufacturerResponseDTO = manufacturerService.printManufacturer(mainToManufacturerDto);
	      
	      return ResponseEntity.status(HttpStatus.OK).body(manufacturerResponseDTO);
	         

	   }
	   



	@GetMapping("/index")
	@Override
	public ModelAndView index() {

		List<ManufacturerDTO> manufacturers = manufacturerService.getAllManufacturers();
		ModelAndView mav = new ModelAndView("/man/index");
		mav.addObject("manufacturers", manufacturers);
		return mav;
	}
}