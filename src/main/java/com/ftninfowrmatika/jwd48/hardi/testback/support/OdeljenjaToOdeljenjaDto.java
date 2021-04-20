package com.ftninfowrmatika.jwd48.hardi.testback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Odeljenje;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.OdeljenjeDTO;

@Component
public class OdeljenjaToOdeljenjaDto implements Converter<Odeljenje, OdeljenjeDTO>{

	@Override
	public OdeljenjeDTO convert(Odeljenje source) {
		OdeljenjeDTO dto = new OdeljenjeDTO();
		dto.setBrojSlobodnihMesta(source.getBrojSlobodnihDana());
		dto.setIme(source.getIme());
		dto.setId(source.getId());
		
		return dto;
	}
	
	public List<OdeljenjeDTO> convert(List<Odeljenje> odeljenja){
		List<OdeljenjeDTO> dto = new ArrayList<OdeljenjeDTO>();
		for(Odeljenje o : odeljenja) {
			dto.add(convert(o));
		}
		return dto;
	}

}
