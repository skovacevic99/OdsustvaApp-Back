package com.ftninfowrmatika.jwd48.hardi.testback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Radnik;
import com.ftninfowrmatika.jwd48.hardi.testback.repository.OdeljenjeRepository;
import com.ftninfowrmatika.jwd48.hardi.testback.repository.RadnikRepository;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.RadnikDTO;

@Component
public class RadnikDtoToRadnik implements Converter<RadnikDTO, Radnik> {
	
	@Autowired
	private RadnikRepository radnikRepository;
	
	@Autowired
	private OdeljenjeRepository odeljenjeRepository;

	@Override
	public Radnik convert(RadnikDTO dto) {
		Radnik entity;
		
		if(dto.getId() == null) {
			entity = new Radnik();
		} else {
			entity = radnikRepository.findOneById(dto.getId());
		}
		
		if(entity != null) {
			entity.setEmail(dto.getEmail());
			entity.setGodinaRadnogStaza(dto.getGodinaRadnogStaza());
			entity.setImeIPrezime(dto.getImeIPrezime());
			entity.setJmbg(dto.getJmbg());
			entity.setOdeljenje(odeljenjeRepository.findOneById(dto.getOdeljenjeId()));
			
			return entity;
		}
		return null;
	}

}
