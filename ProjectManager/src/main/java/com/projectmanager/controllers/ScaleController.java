package com.projectmanager.controllers;

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
import com.projectmanager.models.Scale;
import com.projectmanager.models.ScaleDao;

@Controller
@RequestMapping("/scale")
public class ScaleController {
	
	@Autowired
	ScaleDao scaleDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listScales(Model model) {
		List<Scale> scales = scaleDao.findAll();
		model.addAttribute("scales", scales);
		return "listScales";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addScale(Model model) {
		Scale scale = new Scale();
		model.addAttribute("scale", scale);
		return "addScale";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addScale(@ModelAttribute("scale") @Valid Scale scale, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addScale";
		}
		else {
			scaleDao.save(scale);
			return "redirect:/scale/list";
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteScale(@PathVariable(value="id")Long id) {
		scaleDao.delete(id);
		return "redirect:/scale/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editScale(@PathVariable(value="id")Long id, Model model) {
		Scale scale = scaleDao.findOne(id);
		model.addAttribute("scale", scale);
		return "editScale";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String scaleProject(@ModelAttribute("scale") @Valid Scale scale, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "editScale";
		}
		else {
			scaleDao.save(scale);
			return "redirect:/scale/list";
		}
	}
}
