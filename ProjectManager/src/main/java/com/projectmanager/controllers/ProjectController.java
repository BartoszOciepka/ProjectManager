package com.projectmanager.controllers;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.projectmanager.models.Project;
import com.projectmanager.models.ProjectDao;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectDao projectDao;
	
	List<String> scaleOptions = new ArrayList<>(Arrays.asList("miesiac", "pol roku", "rok"));
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String sayHello(Model model) {
		List<Project> projects = projectDao.findAll();
		model.addAttribute("projects", projects);
		return "allProjects";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProject(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		model.addAttribute("scaleOptions", scaleOptions);
		return "addProject";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProject(@ModelAttribute("project") @Valid Project project, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("scaleOptions", scaleOptions);
			return "addProject";
		}
		else {
			projectDao.save(project);
			return "redirect:/project/list";
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProject(@PathVariable(value="id")Long id) {
		projectDao.delete(id);
		return "redirect:/project/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editProject(@PathVariable(value="id")Long id, Model model) {
		Project project = projectDao.findOne(id);
		model.addAttribute("project", project);
		model.addAttribute("scaleOptions", scaleOptions);
		return "editProject";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editProject(@ModelAttribute("project") @Valid Project project, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("scaleOptions", scaleOptions);
			return "editProject";
		}
		else {
			projectDao.save(project);
			return "redirect:/project/list";
		}
	}
}
