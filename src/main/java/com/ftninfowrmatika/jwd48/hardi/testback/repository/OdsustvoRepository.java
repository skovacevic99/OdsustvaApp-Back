package com.ftninfowrmatika.jwd48.hardi.testback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Odsustvo;

@Repository
public interface OdsustvoRepository extends JpaRepository<Odsustvo, Long> {

	Odsustvo findOneById(Long id);
}
