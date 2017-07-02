package racunari.service;

import java.util.List;

import racunari.model.Proizvodjac;

public interface ProizvodjacService {
	List<Proizvodjac> findAll();

	Proizvodjac findOne(Long id);

	void save(Proizvodjac proizvodjac);

	void remove(Long id);

}
