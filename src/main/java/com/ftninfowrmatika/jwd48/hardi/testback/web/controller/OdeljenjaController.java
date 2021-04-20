package com.ftninfowrmatika.jwd48.hardi.testback.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Odeljenje;
import com.ftninfowrmatika.jwd48.hardi.testback.service.OdeljenjeService;
import com.ftninfowrmatika.jwd48.hardi.testback.support.OdeljenjaToOdeljenjaDto;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.OdeljenjeDTO;

@RestController
@RequestMapping(value = "/api/odeljenja", produces = MediaType.APPLICATION_JSON_VALUE)
public class OdeljenjaController {

	@Autowired
	private OdeljenjeService odeljenjeService;
	
	@Autowired
	private OdeljenjaToOdeljenjaDto toDto;
	
	@GetMapping
	public ResponseEntity<List<OdeljenjeDTO>> getAll(){
		
		List<Odeljenje> odeljenja = odeljenjeService.findAll();
		
		return new ResponseEntity<List<OdeljenjeDTO>>(toDto.convert(odeljenja), HttpStatus.OK);
	}
}
