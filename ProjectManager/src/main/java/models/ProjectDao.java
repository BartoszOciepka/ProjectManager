package models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProjectDao extends CrudRepository<Project, Long> {
	List<Project> findAll();
}
