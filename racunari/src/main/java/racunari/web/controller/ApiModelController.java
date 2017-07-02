package racunari.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import racunari.service.ModelService;
import racunari.support.ModelToModelTDTO;
import racunari.web.dto.ModelDTO;

@RestController
@RequestMapping(value = "/api/modeli")
public class ApiModelController {
	@Autowired
	private ModelService modelService;
	@Autowired
	private ModelToModelTDTO toDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ModelDTO>> get() {
		return new ResponseEntity<>(toDTO.convert(modelService.findAll()),
				HttpStatus.OK);
	}

}
