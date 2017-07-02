package racunari.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import racunari.model.Konfiguracija;

public interface KonfiguracijaService {
	Page<Konfiguracija> findAll(int pageNum);
	Konfiguracija findOne (Long id);
	void save(Konfiguracija konfiguracija);
	void remove(Long id);
	Page<Konfiguracija> pretraga (
			@Param("modelNaziv") String modelNaziv,
			@Param("minCena") Integer minCena,
			@Param("maxCena") Integer maxCena,
			@Param("minRAM") Integer minRAM,
			@Param("maxRAM") Integer maxRAM,
			int pageNum
			);

}
