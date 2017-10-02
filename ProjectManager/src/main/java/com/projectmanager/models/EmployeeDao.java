package com.projectmanager.models;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.projectmanager.models.Employee;

@Service
public interface EmployeeDao extends CrudRepository<Employee, Long> {
	List<Employee> findAll();
}
