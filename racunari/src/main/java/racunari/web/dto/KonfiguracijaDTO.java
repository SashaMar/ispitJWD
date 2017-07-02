package racunari.web.dto;

public class KonfiguracijaDTO {
	private Long id;
	private Long modelId;
	private Long proizvodjacId;
	private String modelProizvodjac;
	private String modelNaziv;
	private Integer ram;
	private Integer cena;

	public String getModelProizvodjac() {
		return modelProizvodjac;
	}

	public void setModelProizvodjac(String modelProizvodjac) {
		this.modelProizvodjac = modelProizvodjac;
	}

	public String getModelNaziv() {
		return modelNaziv;
	}

	public void setModelNaziv(String modelNaziv) {
		this.modelNaziv = modelNaziv;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public Long getProizvodjacId() {
		return proizvodjacId;
	}

	public void setProizvodjacId(Long proizvodjacId) {
		this.proizvodjacId = proizvodjacId;
	}

}
