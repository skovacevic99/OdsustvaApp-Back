package com.ftninfowrmatika.jwd48.hardi.testback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Radnik;
import com.ftninfowrmatika.jwd48.hardi.testback.repository.RadnikRepository;
import com.ftninfowrmatika.jwd48.hardi.testback.service.RadnikService;

@Service
public class JpaRadnikService implements RadnikService {

	@Autowired
	private RadnikRepository radnikRepository;
	
	@Override
	public List<Radnik> findAll() {
		return radnikRepository.findAll();
	}

	@Override
	public Radnik findOneById(Long id) {
		return radnikRepository.findOneById(id);
	}

	@Override
	public Radnik save(Radnik radnik) {
		return radnikRepository.save(radnik);
	}

	@Override
	public Radnik update(Radnik radnik) {
		return radnikRepository.save(radnik);
	}

	@Override
	public Radnik delete(Long id) {
		Radnik radnik = radnikRepository.findOneById(id);
		if(radnik != null) {
			radnikRepository.deleteById(id);
			return radnik;
		}
		return null;
	}

	@Override
	public Page<Radnik> find(String jmbg, Long odeljenjeId, int pageNo) {
		return radnikRepository.search(jmbg, odeljenjeId,  PageRequest.of(pageNo, 4));
	}

}
