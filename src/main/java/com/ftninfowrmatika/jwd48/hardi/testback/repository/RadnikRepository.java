package com.ftninfowrmatika.jwd48.hardi.testback.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Radnik;

@Repository
public interface RadnikRepository extends JpaRepository<Radnik, Long> {
	
	Radnik findOneById(Long id);

	
	@Query("SELECT r FROM Radnik r WHERE " + 
			"(:jmbg = NULL OR r.jmbg LIKE %:jmbg%) AND " + 
			"(:odeljenjeId = NULL OR r.odeljenje.id = :odeljenjeId)")
	Page<Radnik> search(
			@Param("jmbg") String jmbg,
			@Param("odeljenjeId") Long odeljenjeId,
			Pageable pageable);

}
