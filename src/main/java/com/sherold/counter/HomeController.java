package com.sherold.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// Annotation established class as controller
@Controller

// Catch all for root route

@RequestMapping("/")
public class HomeController {
	// GET request for root route
	@RequestMapping("")
	public String index(HttpSession session) {
		// Creates/Updates session
		if (session.getAttribute("counter") == null) {
			session.setAttribute("counter", 1);
		} else {
			Integer counter = (Integer) session.getAttribute("counter");
			counter++;
			session.setAttribute("counter", counter);
		}
		
		return "index.jsp";
	}
	
	// GET requests for other routes
	@RequestMapping("/{route}")
	public String counter(@PathVariable("route") String route, Model model, HttpSession session) {
		// If session is null, create session with count of 0
		if (session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		}
		
		// Event handlers for routing
		if (route.equals("counter")) {		
			// Add session data to model for access on JSP file
			model.addAttribute("count", session.getAttribute("counter"));
			return "counter.jsp";
		} else if (route.equals("counter2")) {
			Integer counter = (Integer) session.getAttribute("counter");
			counter += 2;
			session.setAttribute("counter", counter);
			return "index.jsp";
		} else if (route.equals("reset")) {
			session.setAttribute("counter", 0);
			model.addAttribute("count", session.getAttribute("counter"));
			return "counter.jsp";
		} else {
			Integer counter = (Integer) session.getAttribute("counter");
			counter ++;
			session.setAttribute("counter", counter);
			return "index.jsp";
		}
	}
}
