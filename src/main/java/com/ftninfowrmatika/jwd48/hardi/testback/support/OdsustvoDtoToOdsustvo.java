package com.ftninfowrmatika.jwd48.hardi.testback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Odsustvo;
import com.ftninfowrmatika.jwd48.hardi.testback.service.OdsustvoService;
import com.ftninfowrmatika.jwd48.hardi.testback.service.RadnikService;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.OdsustvoDTO;

@Component
public class OdsustvoDtoToOdsustvo implements Converter<OdsustvoDTO, Odsustvo> {

	@Autowired
	private OdsustvoService odsustvoService;
	
	@Autowired
	private RadnikService radnikService;
	
	@Override
	public Odsustvo convert(OdsustvoDTO dto) {
		Odsustvo entity;
		
		if(dto.getId() == null) {
			entity = new Odsustvo();
		} else {
			entity = odsustvoService.findOneById(dto.getId());
		}
		
		if(entity != null) {
			entity.setDatumPocetka(dto.getDatumPocetka());
			entity.setRadnihDana(dto.getRandnihDana());
			entity.setRadnik(radnikService.findOneById(dto.getRadnikId()));
			
			return entity;
			
		}
		return null;
	}

}
