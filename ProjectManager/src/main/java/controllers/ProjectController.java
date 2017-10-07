package controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import models.Employee;
import models.EmployeeDao;
import models.Project;
import models.ProjectDao;
import models.Scale;
import models.ScaleDao;

@SessionAttributes(value = { "employees", "scaleOptions" })
@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectDao projectDao;

	@Autowired
	ScaleDao scaleDao;

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listProjects(Model model) {
		List<Project> projects = projectDao.findAll();
		model.addAttribute("projects", projects);
		return "allProjects";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProject(Model model) {
		model.addAttribute("project", new Project());
		return "addProject";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProject(@ModelAttribute("project") @Valid Project project, BindingResult result) {
		if (result.hasErrors())	return "addProject";
		else {
			projectDao.save(project);
			return "redirect:/project/list";
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProject(@PathVariable(value = "id") Long id) {
		projectDao.delete(id);
		return "redirect:/project/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editProject(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("project", projectDao.findOne(id));
		return "editProject";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editProject(@ModelAttribute("project") @Valid Project project, BindingResult result, Model model) {
		if (result.hasErrors()) return "editProject";
		else {
			projectDao.save(project);
			return "redirect:/project/list";
		}
	}

	@ModelAttribute("employees")
	public List<Employee> initializeEmployees() {
		return employeeDao.findAll();
	}

	@ModelAttribute("scaleOptions")
	public List<Scale> initializeScaleOptions() {
		return scaleDao.findAll();
	}
}
