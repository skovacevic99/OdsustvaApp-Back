package com.ftninfowrmatika.jwd48.hardi.testback.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Radnik;

public interface RadnikService {

	List<Radnik> findAll();
	
	Radnik findOneById(Long id);
	
	Radnik save(Radnik radnik);
	
	Radnik update(Radnik radnik);
	
	Radnik delete(Long id);

	Page<Radnik> find(String jmbg, Long odeljenjeId, int pageNo);
}
