package racunari.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import racunari.model.Konfiguracija;
import racunari.service.KonfiguracijaService;
import racunari.service.ModelService;
import racunari.web.dto.KonfiguracijaDTO;

@Component
public class KonfiguracijaDTOToKonfiguracija implements
		Converter<KonfiguracijaDTO, Konfiguracija> {
	@Autowired
	private KonfiguracijaService konfiguracijaService;
	@Autowired
	private ModelService modelService;

	@Override
	public Konfiguracija convert(KonfiguracijaDTO konfDTO) {

		Konfiguracija konfiguracija;
		if (konfDTO.getId() == null) {
			konfiguracija = new Konfiguracija();
			konfiguracija.setModel(modelService.findOne(konfDTO.getModelId()));
		} else {
			konfiguracija = konfiguracijaService.findOne(konfDTO.getId());
		}

		konfiguracija.setCena(konfDTO.getCena());
		konfiguracija.setRam(konfDTO.getRam());

		return konfiguracija;
	}

}
