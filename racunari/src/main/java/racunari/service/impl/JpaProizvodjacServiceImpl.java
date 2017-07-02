package racunari.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import racunari.model.Proizvodjac;
import racunari.repository.ProizvodjacRepository;
import racunari.service.ProizvodjacService;

@Service
@Transactional
public class JpaProizvodjacServiceImpl implements ProizvodjacService {
	@Autowired
	private ProizvodjacRepository proizvodjacRepository;

	@Override
	public List<Proizvodjac> findAll() {
		return proizvodjacRepository.findAll();
	}

	@Override
	public Proizvodjac findOne(Long id) {
		return proizvodjacRepository.findOne(id);
	}

	@Override
	public void save(Proizvodjac proizvodjac) {
		proizvodjacRepository.save(proizvodjac);

	}

	@Override
	public void remove(Long id) {
		proizvodjacRepository.delete(id);

	}

}
