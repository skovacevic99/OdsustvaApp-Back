package com.ftninfowrmatika.jwd48.hardi.testback.service;

import java.util.List;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Odeljenje;

public interface OdeljenjeService {

	List<Odeljenje> findAll();
	
	Odeljenje findOneById(Long id);
}
