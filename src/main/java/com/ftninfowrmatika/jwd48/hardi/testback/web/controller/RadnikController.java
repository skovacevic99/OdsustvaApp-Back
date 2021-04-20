package com.ftninfowrmatika.jwd48.hardi.testback.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Radnik;
import com.ftninfowrmatika.jwd48.hardi.testback.service.RadnikService;
import com.ftninfowrmatika.jwd48.hardi.testback.support.RadnikDtoToRadnik;
import com.ftninfowrmatika.jwd48.hardi.testback.support.RadnikToRadnikDto;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.RadnikDTO;

@RestController
@RequestMapping(value = "/api/radnici", produces = MediaType.APPLICATION_JSON_VALUE)
public class RadnikController {
	
	@Autowired
	private RadnikService radnikService;
	
	@Autowired
	private RadnikDtoToRadnik toRadnik;
	
	@Autowired
	private RadnikToRadnikDto toDto;
	
	@GetMapping
	public ResponseEntity<List<RadnikDTO>> getAll(
			@RequestParam(value = "pageNo", defaultValue="0") int pageNo,
			@RequestParam(required = false) String jmbg,
			@RequestParam(required = false) Long odeljenjeId
			){
		
		Page<Radnik> radnici = radnikService.find(jmbg, odeljenjeId, pageNo);
		
		 HttpHeaders headers = new HttpHeaders();
	     headers.add("Total-Pages", Integer.toString(radnici.getTotalPages()));
	     
	     return new ResponseEntity<List<RadnikDTO>>(toDto.convert(radnici.getContent()), headers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RadnikDTO> getOne(@PathVariable Long id){
		
		Radnik radnik = radnikService.findOneById(id);
		
		return new ResponseEntity<RadnikDTO>(toDto.convert(radnik), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RadnikDTO> create(@Valid @RequestBody RadnikDTO dto){
		
		Radnik radnik = toRadnik.convert(dto);
		
		//Racunanje radnog staza
		Integer minSlobodnihDana = 20;
		Integer radniStaz = radnik.getGodinaRadnogStaza();
		
		Integer slobodniDani = minSlobodnihDana + (radniStaz / 5);
		radnik.setSlobodnihDana(slobodniDani);
		
		Radnik sacuvani = radnikService.save(radnik);
		
		return new ResponseEntity<RadnikDTO>(toDto.convert(sacuvani), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RadnikDTO> update(@Valid @RequestBody RadnikDTO dto, @PathVariable Long id){
		
		if(dto.getId() != id) {
			return new ResponseEntity<RadnikDTO>(HttpStatus.BAD_REQUEST);
		}
		
		Radnik radnik = toRadnik.convert(dto);
		radnik.setSlobodnihDana(0);
		
		//Racunanje radnog staza
		Integer minSlobodnihDana = 20;
		Integer radniStaz = radnik.getGodinaRadnogStaza();
		
		Integer slobodniDani = minSlobodnihDana + (radniStaz / 5);
		radnik.setSlobodnihDana(slobodniDani);
		
		Radnik izmenjen = radnikService.update(radnik);
		
		return new ResponseEntity<RadnikDTO>(toDto.convert(izmenjen), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		Radnik obrisan = radnikService.delete(id);
		if(obrisan != null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
