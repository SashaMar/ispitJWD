package racunari.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import racunari.model.Konfiguracija;
import racunari.service.KonfiguracijaService;
import racunari.support.KonfiguracijaDTOToKonfiguracija;
import racunari.support.KonfiguracijatoKonfiguracijaDTO;
import racunari.web.dto.KonfiguracijaDTO;

@RestController
@RequestMapping("/api/konfiguracije")
public class ApiKonfiguracijaController {
	@Autowired
	private KonfiguracijaService konfiguracijaService;
	@Autowired
	private KonfiguracijatoKonfiguracijaDTO toDTO;
	@Autowired
	private KonfiguracijaDTOToKonfiguracija toKonfiguracija;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<KonfiguracijaDTO>> get(
			@RequestParam(required = false) String modelNaziv,
			@RequestParam(required = false) Integer minCena,
			@RequestParam(required = false) Integer maxCena,
			@RequestParam(required = false) Integer minRAM,
			@RequestParam(required = false) Integer maxRAM,
			@RequestParam(defaultValue = "0") int pageNum) {
		Page<Konfiguracija> konfiguracije;

		if (modelNaziv != null || minCena != null || maxCena != null
				|| minRAM != null || maxRAM != null) {

			konfiguracije = konfiguracijaService.pretraga(modelNaziv, minCena,
					maxCena, minRAM, maxRAM, pageNum);

		} else {
			konfiguracije = konfiguracijaService.findAll(pageNum);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages",
				Integer.toString(konfiguracije.getTotalPages()));

		return new ResponseEntity<>(toDTO.convert(konfiguracije.getContent()),
				headers, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<KonfiguracijaDTO> get(@PathVariable Long id) {

		Konfiguracija konfiguracija = konfiguracijaService.findOne(id);

		if (konfiguracija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(konfiguracija), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<KonfiguracijaDTO> add(
			@RequestBody KonfiguracijaDTO konfDTO) {
		Konfiguracija konfiguracija = toKonfiguracija.convert(konfDTO);

		konfiguracijaService.save(konfiguracija);
		return new ResponseEntity<>(toDTO.convert(konfiguracija), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<KonfiguracijaDTO> edit(@PathVariable Long id,
			@RequestBody KonfiguracijaDTO kDTO) {
		if (!id.equals(kDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Konfiguracija konfiguracija = toKonfiguracija.convert(kDTO);
		konfiguracijaService.save(konfiguracija);

		return new ResponseEntity<>(toDTO.convert(konfiguracija), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<KonfiguracijaDTO> delete(@PathVariable Long id) {
		konfiguracijaService.remove(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
