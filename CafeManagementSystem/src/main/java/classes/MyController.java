package classes;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {
	
	@GetMapping("/index")
	public String m1() {
		System.out.println("Inside Index Handler...");
		return "index";
	}
	
	@GetMapping("/about")
	public String m2(Model model) {
		System.out.println("Inside About Handler...");
		
		model.addAttribute("name", "Durgesh Tiwari");
		model.addAttribute("CurrentDate", new Date().toLocaleString());
		
		return "about";
	}
	
	@RequestMapping("/example")
	public String example() {
		
		return "example";
	}
	
	@RequestMapping("/pro")
	public String pro() {
		
		return "pro";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}