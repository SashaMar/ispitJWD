package racunari.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import racunari.model.Model;
import racunari.web.dto.ModelDTO;

@Component
public class ModelToModelTDTO implements Converter<Model, ModelDTO> {

	@Override
	public ModelDTO convert(Model model) {
		ModelDTO mDTO = new ModelDTO();
		mDTO.setId(model.getId());
		mDTO.setNaziv(model.getNaziv());
		mDTO.setProizvodjacNaziv(model.getProizvodjac().getNaziv());

		return mDTO;
	}

	public List<ModelDTO> convert(List<Model> modeli) {
		List<ModelDTO> modeliDTO = new ArrayList<ModelDTO>();
		for (Model m : modeli) {
			modeliDTO.add(convert(m));

		}

		return modeliDTO;

	}

}
