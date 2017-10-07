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
import models.Scale;
import models.ScaleDao;

@Controller
@RequestMapping("/scale")
public class ScaleController {
	
	@Autowired
	ScaleDao scaleDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listScales(Model model) {
		model.addAttribute("scales", scaleDao.findAll());
		return "listScales";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addScale(Model model) {
		model.addAttribute("scale", new Scale());
		return "addScale";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addScale(@ModelAttribute("scale") @Valid Scale scale, BindingResult result) {
		if(result.hasErrors()) return "addScale";
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
		model.addAttribute("scale", scaleDao.findOne(id));
		return "editScale";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editScale(@ModelAttribute("scale") @Valid Scale scale, BindingResult result) {
		if(result.hasErrors()) return "editScale";
		else {
			scaleDao.save(scale);
			return "redirect:/scale/list";
		}
	}
}
