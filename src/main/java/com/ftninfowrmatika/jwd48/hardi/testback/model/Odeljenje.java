package com.ftninfowrmatika.jwd48.hardi.testback.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Odeljenje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String ime;
	
	@Column
	private Integer brojSlobodnihDana;
	
	@OneToMany(mappedBy = "odeljenje")
	private List<Radnik> ranici = new ArrayList<Radnik>();

	public Odeljenje() {
	}

	public Odeljenje(String ime, Integer brojSlobodnihDana) {
		this.ime = ime;
		this.brojSlobodnihDana = brojSlobodnihDana;
	}

	public Odeljenje(Long id, String ime, Integer brojSlobodnihDana) {
		this.id = id;
		this.ime = ime;
		this.brojSlobodnihDana = brojSlobodnihDana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Odeljenje other = (Odeljenje) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public Integer getBrojSlobodnihDana() {
		return brojSlobodnihDana;
	}

	public void setBrojSlobodnihDana(Integer brojSlobodnihDana) {
		this.brojSlobodnihDana = brojSlobodnihDana;
	}

	public List<Radnik> getRanici() {
		return ranici;
	}

	public void setRanici(List<Radnik> ranici) {
		this.ranici = ranici;
	}

	@Override
	public String toString() {
		return "Odeljenje [id=" + id + ", ime=" + ime + ", brojSlobodnihDana=" + brojSlobodnihDana + "]";
	}
	
}
