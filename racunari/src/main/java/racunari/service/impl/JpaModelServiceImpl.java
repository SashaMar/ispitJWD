package racunari.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import racunari.model.Model;
import racunari.repository.ModelRepository;
import racunari.service.ModelService;

@Service
@Transactional
public class JpaModelServiceImpl implements ModelService {
	@Autowired
	private ModelRepository modelRepository;

	@Override
	public List<Model> findAll() {
		return modelRepository.findAll();
	}

	@Override
	public Model findOne(Long id) {
		return modelRepository.findOne(id);
	}

	@Override
	public void save(Model model) {
		modelRepository.save(model);
	}

	@Override
	public void remove(Long id) {
		modelRepository.delete(id);
	}

	@Override
	public List<Model> findByProizvodjacId(Long proizvodjacId) {
		return modelRepository.findByProizvodjacId(proizvodjacId);
	}

}
