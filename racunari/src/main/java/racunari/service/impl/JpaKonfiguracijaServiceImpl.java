package racunari.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import racunari.model.Konfiguracija;
import racunari.repository.KonfiguracijaRepository;
import racunari.service.KonfiguracijaService;

@Service
@Transactional
public class JpaKonfiguracijaServiceImpl implements KonfiguracijaService {
	@Autowired
	private KonfiguracijaRepository konfiguracijaRepository;

	@Override
	public Page<Konfiguracija> findAll(int pageNum) {
		return konfiguracijaRepository.findAll(new PageRequest(pageNum, 2));
	}

	@Override
	public Konfiguracija findOne(Long id) {
		return konfiguracijaRepository.findOne(id);
	}

	@Override
	public void save(Konfiguracija konfiguracija) {
		konfiguracijaRepository.save(konfiguracija);
	}

	@Override
	public void remove(Long id) {
		konfiguracijaRepository.delete(id);
	}

	@Override
	public Page<Konfiguracija> pretraga(String modelNaziv, Integer minCena, Integer maxCena, Integer minRAM,
			Integer maxRAM, int pageNum) {
		if (modelNaziv != null) {
			modelNaziv = "%" + modelNaziv + "%";
		}
		return konfiguracijaRepository.pretraga(modelNaziv, minCena, maxCena, minRAM, maxRAM,
				new PageRequest(pageNum, 2));
	}

}
