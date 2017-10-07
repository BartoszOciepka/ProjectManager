package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Project {
	@NotBlank
	@Column
	String date;
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
			name="emp_proj",
			joinColumns= { @JoinColumn(name="project",
			referencedColumnName="id") },
			
			inverseJoinColumns={ @JoinColumn(name="employee",
			referencedColumnName="id")
			})
	List<Employee> employees;
	@Id
	@GeneratedValue
	Long id;

	@NotBlank
	@Column
	String name;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="scale_id")
	private Scale scale;

	public String getDate() {
		return date;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Scale getScale() {
		return scale;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScale(Scale scale) {
		this.scale = scale;
		if(scale.getProjects().contains(this)) {
			scale.getProjects().add(this);
		}
	}
	@Override
	public String toString() {
		return name + " " + date;
	}
}