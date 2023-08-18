package com.example.mysqlintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/controller")
public class Controller {
	
	@Autowired
	UserRepository userRepository;
	
	@ResponseBody
	@GetMapping(path = "/allUser")
	public String getAlltUser() {
		Iterable<User> users= userRepository.findAll();
		
		String retUser="";
		if(users!= null) {
			for (User user : users) {
				retUser += user;
			}
		}else {
			retUser= "No user";
		}
		return retUser;
	}

}
