package racunari.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import racunari.model.Konfiguracija;
import racunari.web.dto.KonfiguracijaDTO;

@Component
public class KonfiguracijatoKonfiguracijaDTO implements
		Converter<Konfiguracija, KonfiguracijaDTO> {

	@Override
	public KonfiguracijaDTO convert(Konfiguracija konfiguracija) {

		KonfiguracijaDTO konfDTO = new KonfiguracijaDTO();

		konfDTO.setId(konfiguracija.getId());
		konfDTO.setModelId(konfiguracija.getModel().getId());
		konfDTO.setProizvodjacId(konfiguracija.getModel().getProizvodjac()
				.getId());
		konfDTO.setModelProizvodjac(konfiguracija.getModel().getProizvodjac()
				.getNaziv());
		konfDTO.setModelNaziv(konfiguracija.getModel().getNaziv());
		konfDTO.setCena(konfiguracija.getCena());
		konfDTO.setRam(konfiguracija.getRam());

		return konfDTO;
	}

	public List<KonfiguracijaDTO> convert(List<Konfiguracija> konfiguracije) {
		List<KonfiguracijaDTO> konfiguracijeDTO = new ArrayList<KonfiguracijaDTO>();

		for (Konfiguracija konfiguracija : konfiguracije) {
			konfiguracijeDTO.add(convert(konfiguracija));

		}

		return konfiguracijeDTO;

	}
}
