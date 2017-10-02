package com.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.projectmanager.models.EmployeeDao;

@Controller
@RequestMapping("/")
public class DefaultController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello() {
		System.out.println(employeeDao.count());
		return "welcome";
	}
}
