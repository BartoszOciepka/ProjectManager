package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class EmployeeIdToEmployeeConverter implements Converter<Object, Employee>{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee convert(Object element) {
		Long id = Long.parseLong((String)element);
		Employee employee = employeeDao.findOne(id);
		return employee;
	}
}
