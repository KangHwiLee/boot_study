package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@PostMapping("/join")
	public String join(String id, String pw) {
		System.out.println("좀..");
		return "";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("??");
		return "login";
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
}
