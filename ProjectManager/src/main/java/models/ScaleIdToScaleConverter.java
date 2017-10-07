package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import models.Scale;
import models.ScaleDao;

@Component
public class ScaleIdToScaleConverter implements Converter<Object, Scale>{

	@Autowired
	ScaleDao scaleDao;
	
	@Override
	public Scale convert(Object element) {
		Long id = Long.parseLong((String)element);
		Scale scale = scaleDao.findOne(id);
		return scale;
	}
}
