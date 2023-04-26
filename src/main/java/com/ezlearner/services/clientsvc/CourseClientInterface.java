package com.ezlearner.services.clientsvc;

import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TO.Course;

@FeignClient("courses-1")
public interface CourseClientInterface {
	
	@RequestMapping(method=RequestMethod.GET, value="courses")
	ArrayList<Course> getCourses();
	

}
