package com.aiswarya.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aiswarya.exception.ServiceException;
import com.aiswarya.model.Employee;
import com.aiswarya.model.User;
import com.aiswarya.service.EmployeeLoginService;
import com.aiswarya.service.EmployeeService;
import com.aiswarya.service.UserService;
@Controller
@RequestMapping("/employee")

public class EmployeeController {
	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	@GetMapping("/Login")
	public String logIn(@RequestParam("Emailid") String emailId, @RequestParam("password") String password) {

		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Logging In...");
		Employee employee=new Employee();
		EmployeeLoginService employeeservice=new EmployeeLoginService();
		employee.setEmailId(emailId);
		employee.setPassword(password);

		try {

			employeeservice.login(emailId, password);
			return "redirect:../EmployeeLogin.jsp";

		} catch (ServiceException e) {

			LOGGER.log(Level.SEVERE, "!!!!Log In Failed Exception occured!!!", e);

			return "redirect:../EmployeeLoginLogin.jsp";

		}
	}

}
