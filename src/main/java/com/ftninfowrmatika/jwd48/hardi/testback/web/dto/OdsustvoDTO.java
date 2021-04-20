package com.ftninfowrmatika.jwd48.hardi.testback.web.dto;

import javax.validation.constraints.Positive;

public class OdsustvoDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private String datumPocetka;
	
	private Integer randnihDana;
	
	private Long radnikId;

	public OdsustvoDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Integer getRandnihDana() {
		return randnihDana;
	}

	public void setRandnihDana(Integer randnihDana) {
		this.randnihDana = randnihDana;
	}

	public Long getRadnikId() {
		return radnikId;
	}

	public void setRadnikId(Long radnikId) {
		this.radnikId = radnikId;
	}
	
}
