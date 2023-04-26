package com.ezlearner.services.clientsvc;

import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TO.User;

@FeignClient("tutors")
public interface TutorsClientInterface {
	
	@RequestMapping(method=RequestMethod.GET, value="tutors")
	ArrayList<User> getUsers();
	

}
