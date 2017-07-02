package racunari.web.dto;

public class ModelDTO {
	private Long id;
	private String naziv;
	private String proizvodjacNaziv;

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

	public String getProizvodjacNaziv() {
		return proizvodjacNaziv;
	}

	public void setProizvodjacNaziv(String proizvodjacNaziv) {
		this.proizvodjacNaziv = proizvodjacNaziv;
	}

}
