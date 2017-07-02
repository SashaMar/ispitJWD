package racunari.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Model {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@ManyToOne(fetch = FetchType.EAGER)
	private Proizvodjac proizvodjac;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
		if (proizvodjac != null && !proizvodjac.getModeli().contains(this)) {
			proizvodjac.getModeli().add(this);
		}
	}

}
