package com.ftninfowrmatika.jwd48.hardi.testback.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class RadnikDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	@Length(max = 13, min = 13, message = "Jmbg mora imati 13 karaktera")
	private String jmbg;
	
	private String imeIPrezime;
	
	@Email(message = "Mejl nije u dobrom formatu.")
	private String email;
	
	private Integer godinaRadnogStaza;
	
	private String odeljenjeIme;
	
	private Integer brojSlobodnihDana;
	
	private Long odeljenjeId;

	public RadnikDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGodinaRadnogStaza() {
		return godinaRadnogStaza;
	}

	public void setGodinaRadnogStaza(Integer godinaRadnogStaza) {
		this.godinaRadnogStaza = godinaRadnogStaza;
	}

	public Long getOdeljenjeId() {
		return odeljenjeId;
	}

	public void setOdeljenjeId(Long odeljenjeId) {
		this.odeljenjeId = odeljenjeId;
	}

	public String getOdeljenjeIme() {
		return odeljenjeIme;
	}

	public void setOdeljenjeIme(String odeljenjeIme) {
		this.odeljenjeIme = odeljenjeIme;
	}

	public Integer getBrojSlobodnihDana() {
		return brojSlobodnihDana;
	}

	public void setBrojSlobodnihDana(Integer brojSlobodnihDana) {
		this.brojSlobodnihDana = brojSlobodnihDana;
	}
	
}
