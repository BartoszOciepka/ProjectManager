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
import models.Employee;
import models.EmployeeDao;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		List<Employee> employees = employeeDao.findAll();
		model.addAttribute("employees", employees);
		return "allEmployees";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result) {
		if (result.hasErrors())
			return "addEmployee";
		else {
			employeeDao.save(employee);
			return "redirect:/employee/list";
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable(value = "id") Long id) {
		employeeDao.delete(id);
		return "redirect:/employee/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable(value = "id") Long id, Model model) {
		Employee employee = employeeDao.findOne(id);
		model.addAttribute("employee", employee);
		return "editEmployee";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result) {
		if (result.hasErrors())
			return "editEmployee";
		else {
			employeeDao.save(employee);
			return "redirect:/employee/list";
		}
	}
}
