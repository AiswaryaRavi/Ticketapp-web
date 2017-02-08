package com.aiswarya.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

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
	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	@GetMapping("/Login")
	public String logIn(@RequestParam("Emailid") String emailId, @RequestParam("password") String password,ModelMap modelmap) {

		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Logging In...");
		User user = new User();
		UserService userService = new UserService();
		user.setEmailId(emailId);
		user.setPassword(password);

		try {

			userService.login(emailId, password);
			return "redirect:../UserOptions.jsp";

		} catch (ServiceException e) {

			modelmap.addAttribute("ERROR", e.getMessage());


			return "/Login.jsp";

		}
	}
		@GetMapping("/Register")
		public String Register(@RequestParam("Name") String name,@RequestParam("Emailid") String emailId, @RequestParam("password") String password,ModelMap modelmap) {

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
		@GetMapping("/CreateTicket")
		public String CreateTicket(@RequestParam("Emailid") String emailId, @RequestParam("password") String password,@RequestParam("Subject") String subject,@RequestParam("Description") String description,@RequestParam("Department") String department,@RequestParam("priority") String priority) {

			TicketService ticketservice=new TicketService();
			
			try {

				ticketservice.ticketCreation(emailId, password, subject, description, department, priority);
				return "redirect:../CreationConfirmation.jsp";

			} catch (ServiceException e) {

				LOGGER.log(Level.SEVERE, "!!!!Creation Failed Exception occured!!!", e);

				return "/CreateTicket.jsp";

			}
		
		
		}
		@GetMapping("/UpdateTicket")
		public String UpdateTicket(@RequestParam("Emailid") String emailId, @RequestParam("password") String password,@RequestParam("Tid") Integer id, @RequestParam("Subject") String subject,@RequestParam("Description") String description) {

			TicketService ticketservice=new TicketService();
			
			try {

				ticketservice.ticketUpdation(emailId, password, id, description);
				return "redirect:/UpdationConfirmation.jsp";

			} catch (ServiceException e) {

				LOGGER.log(Level.SEVERE, "!!!!Updation Failed Exception occured!!!", e);

				return "redirect:../UpdateTicket.jsp";

			}
		
		
		}
		@GetMapping("/CloseTicket")
		public String CloseTicket(@RequestParam("Emailid") String emailId, @RequestParam("password") String password,@RequestParam("Tid") Integer id) {

			TicketService ticketservice=new TicketService();
			
			try {

				ticketservice.closeTicket(emailId, password, id);
				return "redirect:/CloseConfirmation.jsp";

			} catch (ServiceException e) {

				LOGGER.log(Level.SEVERE, "!!!!Updation Failed Exception occured!!!", e);

				return "redirect:../CloseTicket.jsp";

			}
		
		
		}
}

