package racunari.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

public class Proizvodjac {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@OneToMany(mappedBy = "proizvodjac", fetch = FetchType.LAZY)
	private List<Model> modeli = new ArrayList<>();

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

	public List<Model> getModeli() {
		return modeli;
	}

	public void setModeli(List<Model> modeli) {
		this.modeli = modeli;
	}

	public void addModel(Model model) {
		this.modeli.add(model);

		if (model != null && !this.equals(model.getProizvodjac())) {
			model.setProizvodjac(this);
		}
	}

}
