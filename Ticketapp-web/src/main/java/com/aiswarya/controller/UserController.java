package com.aiswarya.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aiswarya.exception.ServiceException;
import com.aiswarya.model.Departments;
import com.aiswarya.model.TicketTransaction;
import com.aiswarya.model.User;
import com.aiswarya.service.TicketService;
import com.aiswarya.service.UserService;

@Controller
@RequestMapping("/home")

public class UserController {
	User user = new User();

	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	@GetMapping("/Login")
	public String logIn(@RequestParam("emailId") String emailId, @RequestParam("password") String password,
			ModelMap modelmap, HttpSession session) {

		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Logging In...");
		UserService userService = new UserService();
		User user = new User();
		user.setEmailId(emailId);
		user.setPassword(password);
		session.setAttribute("Logged_in_user", user);

		try {
			if (userService.login(emailId, password))
				;
			session.setAttribute("Logged_in_user", user);

			return "../UserOptions.jsp";

		} catch (ServiceException e) {

			modelmap.addAttribute("ERROR", e.getMessage());

			return "../Login.jsp";

		}
	}

	@GetMapping("/Register")
	public String Register(@RequestParam("Name") String name, @RequestParam("Emailid") String emailId,
			@RequestParam("password") String password, ModelMap modelmap) {

		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Logging In...");
		User user = new User();
		UserService userService = new UserService();
		user.setName(name);
		System.out.println(name);
		user.setEmailId(emailId);
		user.setPassword(password);

		try {

			userService.register(user);
			return "redirect:/Login.jsp";

		} catch (ServiceException e) {

			modelmap.addAttribute("ERROR", e.getMessage());

			return "/Register.jsp";

		}

	}

	@GetMapping("/Creation")
	public String TicketCreation() {
		return "../CreateTicket.jsp";
	}

	@GetMapping("/CreateTicket")
	public String CreateTicket(@RequestParam("Subject") String subject, @RequestParam("Description") String description,
			@RequestParam("department") String department, @RequestParam("priority") String priority, ModelMap modelmap,
			HttpSession session) {

		TicketService ticketservice = new TicketService();
		User user = new User();

		try {
			user = (User) session.getAttribute("Logged_in_user");

			ticketservice.ticketCreation(user.getEmailId(), subject, description, department, priority);
			return "redirect:../CreationConfirmation.jsp";

		} catch (ServiceException e) {

			modelmap.addAttribute("ERROR", e.getMessage());

			return "../CreateTicket.jsp";

		}

	}

	@GetMapping("/Updation")
	public String TicketUpdation(){
		return "../UpdateTicket.jsp";
	}

	@GetMapping("/UpdateTicket")
	public String UpdateTicket( @RequestParam("tid") Integer id,
			@RequestParam("description") String description, ModelMap modelmap,HttpSession session) {

		TicketService ticketservice = new TicketService();

		try {
			user = (User) session.getAttribute("Logged_in_user");


			ticketservice.ticketUpdation(user.getEmailId(), id, description);
			return "../UpdationConfirmation.jsp";

		} catch (ServiceException e) {

			modelmap.addAttribute("ERROR", e.getMessage());

			return "../UpdateTicket.jsp";

		}

	}

	@GetMapping("/Close")
	public String TicketClose(){
		return "../CloseTicket.jsp";
	}

	@GetMapping("/CloseTicket")
	public String CloseTicket(@RequestParam("emailId") String emailId, @RequestParam("tid") Integer tid,
			ModelMap modelmap,HttpSession session) {

		TicketService ticketservice = new TicketService();

		try {
			user = (User) session.getAttribute("Logged_in_user");

			ticketservice.closeTicket(emailId, tid);
			return "../CloseConfirmation.jsp";

		} catch (ServiceException e) {

			modelmap.addAttribute("ERROR", e.getMessage());

			return "../CloseTicket.jsp";

		}

	}
}
