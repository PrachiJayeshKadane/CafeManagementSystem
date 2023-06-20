package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CafeController {
	
	@Autowired
	UserRepo userrepo;

	@GetMapping("/")
	public String m1() {
		return "index";
	}
	
	@GetMapping("/loginform")
	public String m2() {
		return "loginform";
	}

	@PostMapping("/login")
	public String m3(User user) {
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		System.out.println("Username From Browser : " + username);
		System.out.println("Password From browser : " + password);
		
		User user1 = userrepo.findByUsername(username, password);
		
		if (user1==null) {
			return "failure";
		}
		
		String dbusername = user1.getUsername();
		String dbpassword = user1.getPassword();
		
		System.out.println("Database Username : " + dbusername);
		System.out.println("Database Password : " + dbpassword);
		
		
		if (username.equals(dbusername) && password.equals(dbpassword)&&
			username != null && password != null &&
			!username.equals("") && !password.equals("") 	) {
			
			return "pro";
			
		} else {
			
			return "failure";
			
		}
	}
	
	@GetMapping("/registration")
	public String m4() {
		
		return "registrationForm";
	}
	
//	successRegistration
	@PostMapping("successRegistration")
	public String m5(User user) {
		userrepo.save(user);
		return "succregister";
	}
	
}