package com.ftninfowrmatika.jwd48.hardi.testback.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

@Entity
public class Radnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String jmbg;
	
	@Column(nullable = false)
	private String imeIPrezime;
	
	@Column
	@Email
	private String email;
	
	@Column
	private Integer godinaRadnogStaza;

	@Column
	private Integer slobodnihDana;
	
	@ManyToOne
	private Odeljenje odeljenje;
	
	@OneToMany(mappedBy = "radnik", cascade = CascadeType.ALL)
	private List<Odsustvo> odsustva = new ArrayList<Odsustvo>();

	public Radnik() {
	}

	public Radnik(String jmbg, String imeIPrezime, @Email String email, Integer godinaRadnogStaza,
			Integer slobodnihDana, Odeljenje odeljenje, List<Odsustvo> odsustva) {
		this.jmbg = jmbg;
		this.imeIPrezime = imeIPrezime;
		this.email = email;
		this.godinaRadnogStaza = godinaRadnogStaza;
		this.slobodnihDana = slobodnihDana;
		this.odeljenje = odeljenje;
		this.odsustva = odsustva;
	}

	public Radnik(Long id, String jmbg, String imeIPrezime, @Email String email, Integer godinaRadnogStaza,
			Integer slobodnihDana, Odeljenje odeljenje, List<Odsustvo> odsustva) {
		this.id = id;
		this.jmbg = jmbg;
		this.imeIPrezime = imeIPrezime;
		this.email = email;
		this.godinaRadnogStaza = godinaRadnogStaza;
		this.slobodnihDana = slobodnihDana;
		this.odeljenje = odeljenje;
		this.odsustva = odsustva;
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

	public Integer getSlobodnihDana() {
		return slobodnihDana;
	}

	public void setSlobodnihDana(Integer slobodnihDana) {
		this.slobodnihDana = slobodnihDana;
	}

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	public List<Odsustvo> getOdsustva() {
		return odsustva;
	}

	public void setOdsustva(List<Odsustvo> odsustva) {
		this.odsustva = odsustva;
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
		Radnik other = (Radnik) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Radnik [id=" + id + ", jmbg=" + jmbg + ", imeIPrezime=" + imeIPrezime + ", email=" + email
				+ ", godinaRadnogStaza=" + godinaRadnogStaza + ", slobodnihDana=" + slobodnihDana + ", odeljenje="
				+ odeljenje + ", odsustva=" + odsustva + "]";
	}
	
}
