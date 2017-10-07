package models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Scale {

	@Id
	@GeneratedValue
	public Long id;
	@Column
	@NotBlank
	public String name;
	@OneToMany(mappedBy="scale", fetch =FetchType.EAGER)
	private List<Project> projects;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
