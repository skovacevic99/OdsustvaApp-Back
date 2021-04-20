package com.ftninfowrmatika.jwd48.hardi.testback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Radnik;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.RadnikDTO;

@Component
public class RadnikToRadnikDto implements Converter<Radnik, RadnikDTO> {

	@Override
	public RadnikDTO convert(Radnik source) {
		RadnikDTO dto = new RadnikDTO();
		dto.setId(source.getId());
		dto.setEmail(source.getEmail());
		dto.setGodinaRadnogStaza(source.getGodinaRadnogStaza());
		dto.setImeIPrezime(source.getImeIPrezime());
		dto.setJmbg(source.getJmbg());
		dto.setOdeljenjeId(source.getOdeljenje().getId());
		dto.setOdeljenjeIme(source.getOdeljenje().getIme());
		dto.setBrojSlobodnihDana(source.getSlobodnihDana());
		
		return dto;
	}
	
	public List<RadnikDTO> convert(List<Radnik> radnici){
		List<RadnikDTO> dto = new ArrayList<RadnikDTO>();
		for(Radnik r : radnici) {
			dto.add(convert(r));
		}
		return dto;
	}

}
