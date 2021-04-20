package com.ftninfowrmatika.jwd48.hardi.testback.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Odsustvo;
import com.ftninfowrmatika.jwd48.hardi.testback.service.OdsustvoService;
import com.ftninfowrmatika.jwd48.hardi.testback.support.OdsustvoDtoToOdsustvo;
import com.ftninfowrmatika.jwd48.hardi.testback.support.OdsustvoToOdsustvoDto;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.OdsustvoDTO;

@RestController
@RequestMapping(value = "/api/odsustva", produces = MediaType.APPLICATION_JSON_VALUE)
public class OdsustvoController {
	
	@Autowired
	private OdsustvoService odsustvoService;
	
	@Autowired
	private OdsustvoDtoToOdsustvo toOdsustvo;
	
	@Autowired
	private OdsustvoToOdsustvoDto toDto;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OdsustvoDTO> create(@Valid @RequestBody OdsustvoDTO dto){
		
		System.out.println("*****************" + dto.toString());
		Odsustvo odsustvo = toOdsustvo.convert(dto);
		Odsustvo novoOdsustvo = odsustvoService.save(odsustvo);
		
		if(novoOdsustvo == null) {
			return new ResponseEntity<OdsustvoDTO>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<OdsustvoDTO>(toDto.convert(novoOdsustvo), HttpStatus.OK);
		}
	}

}
