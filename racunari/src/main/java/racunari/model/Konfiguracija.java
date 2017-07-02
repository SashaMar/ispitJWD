package racunari.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Konfiguracija {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private Integer ram;
	@Column
	private Integer cena;
	@OneToOne(fetch = FetchType.EAGER)
	private Model model;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getCena() {
		return cena;
	}

	public void setCena(Integer cena) {
		this.cena = cena;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;

	}

}
