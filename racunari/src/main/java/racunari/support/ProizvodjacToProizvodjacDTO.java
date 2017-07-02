package racunari.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import racunari.model.Proizvodjac;
import racunari.web.dto.ProizvodjacDTO;

@Component
public class ProizvodjacToProizvodjacDTO implements
		Converter<Proizvodjac, ProizvodjacDTO> {

	@Override
	public ProizvodjacDTO convert(Proizvodjac proizvodjac) {

		ProizvodjacDTO pDTO = new ProizvodjacDTO();
		pDTO.setId(proizvodjac.getId());
		pDTO.setNaziv(proizvodjac.getNaziv());
		return pDTO;
	}

	public List<ProizvodjacDTO> convert(List<Proizvodjac> proizvodjaci) {

		List<ProizvodjacDTO> ret = new ArrayList<ProizvodjacDTO>();

		for (Proizvodjac p : proizvodjaci) {
			ret.add(convert(p));

		}
		return ret;

	}

}
