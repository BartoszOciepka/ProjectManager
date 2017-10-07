package models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ScaleDao extends CrudRepository<Scale, Long>{
	List<Scale> findAll();
}
