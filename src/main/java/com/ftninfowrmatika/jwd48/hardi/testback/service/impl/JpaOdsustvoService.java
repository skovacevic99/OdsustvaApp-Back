package com.ftninfowrmatika.jwd48.hardi.testback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Odsustvo;
import com.ftninfowrmatika.jwd48.hardi.testback.model.Radnik;
import com.ftninfowrmatika.jwd48.hardi.testback.repository.OdsustvoRepository;
import com.ftninfowrmatika.jwd48.hardi.testback.service.OdsustvoService;
import com.ftninfowrmatika.jwd48.hardi.testback.service.RadnikService;

@Service
public class JpaOdsustvoService implements OdsustvoService {

	@Autowired
	private OdsustvoRepository odsustvoRepository;
	
	@Autowired
	private RadnikService radnikService;
	
	@Override
	public List<Odsustvo> findAll() {
		return odsustvoRepository.findAll();
	}

	@Override
	public Odsustvo findOneById(Long id) {
		return odsustvoRepository.findOneById(id);
	}

	@Override
	public Odsustvo save(Odsustvo odsustvo) {
		if(odsustvo.getRadnihDana() > odsustvo.getRadnik().getSlobodnihDana()) {
			return null;
		} else {
			if(odsustvo.getRadnik().getSlobodnihDana() == 0) {
				return null;
			} else {
				Radnik radnik = odsustvo.getRadnik();
				radnik.setSlobodnihDana(radnik.getSlobodnihDana() - odsustvo.getRadnihDana());
				radnikService.update(radnik);
				odsustvoRepository.save(odsustvo);
				return odsustvo;
			}
		}
	}

}
