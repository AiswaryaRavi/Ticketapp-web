package com.aiswarya.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aiswarya.exception.ServiceException;
import com.aiswarya.model.Employee;
import com.aiswarya.model.TicketTransaction;
import com.aiswarya.model.User;
import com.aiswarya.service.EmployeeLoginService;
import com.aiswarya.service.EmployeeService;
import com.aiswarya.service.UserService;

@Controller
@RequestMapping("/employee")

public class EmployeeController {
	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
	Employee employee = new Employee();
	EmployeeService employeeservice=new EmployeeService();

	@GetMapping("/Login")
	public String logIn(@RequestParam("emailId") String emailId, @RequestParam("password") String password,
			ModelMap modelmap, HttpSession session) {

		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Logging In...");
		EmployeeLoginService employeeservice = new EmployeeLoginService();
		employee.setEmailId(emailId);
		employee.setPassword(password);
		session.setAttribute("Logged_in_user", employee);

		try {

			if (employeeservice.login(emailId, password))
				
			session.setAttribute("Logged_in_user", employee);

			return "../EmployeeOptions.jsp";

		} catch (ServiceException e) {

			modelmap.addAttribute("ERROR", e.getMessage());

			return "../EmployeeLogin.jsp";

		}
	}

	@GetMapping("/Assign")
	public String TicketAssignment() {
		return "../AssignEmployee.jsp";

	}

	@GetMapping("/AssignEmployee")
	public String assignEmployee(@RequestParam("tid") int ticketId, @RequestParam("eid") int employeeId, ModelMap map,
			HttpSession session) throws ServiceException {

		EmployeeService emp = new EmployeeService();

		try {
			employee = (Employee) session.getAttribute("Logged_in_user");

			emp.reassignEmployee(employee.getEmailId(), employeeId, ticketId);
			
			return "../EmployeeAssignmentConfirmation.jsp";

		} catch (ServiceException e) {
			map.addAttribute("ERROR", e.getMessage());
			return "../AssignEmployee.jsp";

		}

	}

	@GetMapping("/Reply")
	public String ReplySolution(){
		return "../ReplyTicket.jsp";
	}

	@GetMapping("/ReplyTicket")
	public String ReplyTicket(@RequestParam("tid") int ticketId,
			@RequestParam("solution") String solution, ModelMap map,HttpSession session) throws ServiceException {

		EmployeeService emp = new EmployeeService();

		try {
			employee = (Employee) session.getAttribute("Logged_in_user");

			emp.replyTic(employee.getEmailId(), solution, ticketId);
			return "../ReplyTicket.jsp";

		} catch (ServiceException e) {
			map.addAttribute("ERROR", e.getMessage());
			return "../ReplyTicket.jsp";

		}
	}
	@GetMapping("/displayTickets")
	public String userViewTickets(ModelMap modelmap,HttpSession session) throws ServiceException {
		try{
		employee=(Employee) session.getAttribute("Logged_in_user");
		List<TicketTransaction> ticketList = employeeservice.DisplayEmployeeTickets(employee.getEmailId());
		modelmap.addAttribute("TICKET_LIST", ticketList);
		return "../EmployeeViewTicket.jsp";
		}
		catch (ServiceException e) {

			modelmap.addAttribute("ERROR", e.getMessage());

			return "../EmployeeOptions.jsp";

		}
}

	

}
