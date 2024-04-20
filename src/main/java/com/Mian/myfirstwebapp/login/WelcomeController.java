package com.Mian.myfirstwebapp.login;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	//@RequestParam String name,ModelMap model
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
	
		
		//model.put("name", name);  everything in model 
		//logger.debug("Request param is {}",name);
		//logger.info("AT info level");
		//System.out.println("Request param is "+ name);
		
		return "welcome";
	}
	private String getLoggedinUsername() {
		Authentication authentication =
				SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
		}

}


