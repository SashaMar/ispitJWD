package racunari.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import racunari.model.Model;
import racunari.service.ModelService;
import racunari.service.ProizvodjacService;
import racunari.support.ModelToModelTDTO;
import racunari.support.ProizvodjacToProizvodjacDTO;
import racunari.web.dto.ModelDTO;
import racunari.web.dto.ProizvodjacDTO;

@RestController
@RequestMapping(value = "/api/proizvodjaci")
public class ApiProizvodjacController {
	@Autowired
	private ProizvodjacService proizvodjacService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private ProizvodjacToProizvodjacDTO toDTO;
	@Autowired
	private ModelToModelTDTO modelToDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProizvodjacDTO>> get() {

		return new ResponseEntity<>(
				toDTO.convert(proizvodjacService.findAll()), HttpStatus.OK);

	}

	@RequestMapping(value = "/{proizvodjacId}/modeli")
	public ResponseEntity<List<ModelDTO>> getModeliProizvodjaca(
			@PathVariable Long proizvodjacId) {
		List<Model> modeli = modelService.findByProizvodjacId(proizvodjacId);

		return new ResponseEntity<>(modelToDTO.convert(modeli), HttpStatus.OK);

	}
}
