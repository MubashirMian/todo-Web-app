package com.Mian.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // handles web request
public class SayHelloController {

	// say hello 
	@RequestMapping("say-hello") // 
	@ResponseBody // as the method returns a string, we need to return the string as it is
	public String sayHello() 
	{
		return "HELLO! WHAT ARE YOU LEARNING TODAY!";
	}
	@RequestMapping("say-hello-html") // 
	@ResponseBody // as the method returns a string, we need to return the string as it is
	public String sayHelloHtml() 
	{
		StringBuffer  sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First HTML PAGE - Changed</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html body");
		sb.append("</body");
		sb.append("</html>");
		
		return sb.toString();
	}
	//jsp java server pages
	@RequestMapping("say-hello-jsp") 
	// src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	//@ResponseBody // as the method returns a string, we need to return the string as it is
	public String sayHellojsp() 
	{
		return "sayHello";
	}
}
