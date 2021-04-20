package com.ftninfowrmatika.jwd48.hardi.testback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Odeljenje;
import com.ftninfowrmatika.jwd48.hardi.testback.repository.OdeljenjeRepository;
import com.ftninfowrmatika.jwd48.hardi.testback.service.OdeljenjeService;

@Service
public class JpaOdeljenjeService implements OdeljenjeService {

	@Autowired
	private OdeljenjeRepository odeljenjeRepository;
	
	@Override
	public List<Odeljenje> findAll() {
		return odeljenjeRepository.findAll();
	}

	@Override
	public Odeljenje findOneById(Long id) {
		return odeljenjeRepository.findOneById(id);
	}

}
