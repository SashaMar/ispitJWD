package racunari;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import racunari.model.Konfiguracija;
import racunari.model.Model;
import racunari.model.Proizvodjac;
import racunari.service.KonfiguracijaService;
import racunari.service.ModelService;
import racunari.service.ProizvodjacService;

@Component
public class TestData {
	@Autowired
	private KonfiguracijaService konfiguracijaService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private ProizvodjacService proizvodjacService;

	@PostConstruct
	public void init() {
		Proizvodjac proizvodjac = new Proizvodjac();
		proizvodjac.setNaziv("Lenovo");
		proizvodjacService.save(proizvodjac);

		Proizvodjac proizvodjac2 = new Proizvodjac();
		proizvodjac2.setNaziv("LG");
		proizvodjacService.save(proizvodjac2);

		Proizvodjac proizvodjac3 = new Proizvodjac();
		proizvodjac3.setNaziv("Dell");
		proizvodjacService.save(proizvodjac3);

		Model model = new Model();
		model.setNaziv("Model1");
		model.setProizvodjac(proizvodjac2);

		modelService.save(model);

		Model model2 = new Model();
		model2.setNaziv("Model2");
		model2.setProizvodjac(proizvodjac2);
		modelService.save(model2);

		Model model3 = new Model();
		model3.setNaziv("Model3");
		model3.setProizvodjac(proizvodjac);
		modelService.save(model3);

		Konfiguracija konfiguracija = new Konfiguracija();
		konfiguracija.setCena(1200);
		konfiguracija.setModel(model3);
		konfiguracija.setRam(2);
		konfiguracijaService.save(konfiguracija);

		Konfiguracija konfiguracija2 = new Konfiguracija();
		konfiguracija2.setCena(3000);
		konfiguracija2.setModel(model2);
		konfiguracija2.setRam(6);
		konfiguracijaService.save(konfiguracija2);
	}
}
