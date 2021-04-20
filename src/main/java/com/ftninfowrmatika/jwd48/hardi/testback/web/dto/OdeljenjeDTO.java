package com.ftninfowrmatika.jwd48.hardi.testback.web.dto;

import javax.validation.constraints.Positive;

public class OdeljenjeDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private String ime;
	
	private Integer brojSlobodnihMesta;

	public OdeljenjeDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Integer getBrojSlobodnihMesta() {
		return brojSlobodnihMesta;
	}

	public void setBrojSlobodnihMesta(Integer brojSlobodnihMesta) {
		this.brojSlobodnihMesta = brojSlobodnihMesta;
	}
	
}
