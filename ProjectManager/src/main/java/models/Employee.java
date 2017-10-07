package models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee {

	@NotBlank
	@Column
	String firstName;
	@Id
	@GeneratedValue
	Long id;
	@NotBlank
	@Column
	String lastName;
	@NotBlank
	@ManyToMany(mappedBy="employees")
	List<Project> projects;

	
	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
