package racunari.service;

import java.util.List;

import racunari.model.Model;

public interface ModelService {
	List<Model> findAll();

	Model findOne(Long id);

	void save(Model model);

	void remove(Long id);

	List<Model> findByProizvodjacId(Long proizvodjacId);

}
