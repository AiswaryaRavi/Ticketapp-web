package com.aiswarya.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String logIn(@RequestParam("emailId") String emailId, @RequestParam("password") String password,ModelMap modelmap) {

		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Logging In...");
		Employee employee=new Employee();
		EmployeeLoginService employeeservice=new EmployeeLoginService();
	

		try {

			employeeservice.login(emailId, password);
			return "../EmployeeOptions.jsp";

		} catch (ServiceException e) {

			modelmap.addAttribute("ERROR", e.getMessage());


			return "../EmployeeLogin.jsp";

		}
	}
	@GetMapping("/Assign")
	public String TicketCreation(@RequestParam("emailId") String emailId,ModelMap modelmap){
		modelmap.addAttribute("emailId", emailId);
		return "../AssignEmployee.jsp";
	}
	@GetMapping("/AssignEmployee")
	public String assignEmployee(@RequestParam("emailId") String emailId,@RequestParam("tid") int ticketId, @RequestParam("eid") int employeeId,ModelMap map)
			throws ServiceException {

		EmployeeService emp=new EmployeeService();
	

		try {
			emp.reassignEmployee(emailId,employeeId, ticketId);
			System.out.println("hi");
			return "../EmployeeAssignmentConfirmation.jsp";

		} catch (ServiceException e) {
			map.addAttribute("ERROR", e.getMessage());
			return "../AssignEmployee.jsp";

		}

}
	@GetMapping("/Reply")
	public String ReplySolution(@RequestParam("emailId") String emailId,ModelMap modelmap){
		modelmap.addAttribute("emailId", emailId);
		return "../ReplyTicket.jsp";
	}
	@GetMapping("/ReplyTicket")
	public String ReplyTicket(@RequestParam("emailId") String emailId,@RequestParam("tid") int ticketId, @RequestParam("solution") String solution,ModelMap map)
			throws ServiceException {

		EmployeeService emp=new EmployeeService();
	

		try {
			emp.replyTic(emailId,solution, ticketId);
			return "../ReplyConfirmation.jsp";

		} catch (ServiceException e) {
			map.addAttribute("ERROR", e.getMessage());
			return "../ReplyTicket.jsp";

		}
	}
		@GetMapping("/Update")
		public String UpdateSolution(@RequestParam("emailId") String emailId,ModelMap modelmap){
			modelmap.addAttribute("emailId", emailId);
			return "../ReplyTicket.jsp";
		}
		@GetMapping("/UpdateSolution")
		public String UpdateTicket(@RequestParam("emailId") String emailId,@RequestParam("tid") int ticketId, @RequestParam("solution") String solution,ModelMap map)
				throws ServiceException {

			EmployeeService emp=new EmployeeService();
		

			try {
				emp.replyTic(emailId,solution, ticketId);
				return "../UpdateSolutionConfirmation.jsp";

			} catch (ServiceException e) {
				map.addAttribute("ERROR", e.getMessage());
				return "../UpdateSolution.jsp";

			}

}


}
