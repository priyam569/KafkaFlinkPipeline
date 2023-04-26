package com.ezlearner.services.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezlearner.services.clientsvc.CourseClientInterface;
import com.ezlearner.services.clientsvc.TutorsClientInterface;
import com.ezlearner.services.configurations.MyProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import TO.Course;
import TO.Person;
import TO.Services;
import TO.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ServicesController {
	

	@Autowired private KafkaTemplate<String,Person> kafkaTemplate;
	// @Autowired
	// private Myconfigurations myconfigurations;
	 // List<Services> services = new ArrayList<Services>();
	/*
	 * @Autowired TutorsClientInterface tutorsClientInterface;
	 * 
	 * @Autowired CourseClientInterface courseClientInterface;
	 * 
	 * private Logger LOGGER = Logger.getLogger("InfoLogging");
	 * 
	 * 
	 * 
	 * @GetMapping("/services")
	 * 
	 * @CircuitBreaker(name="servicesCircuitBreaker", fallbackMethod =
	 * "getMockservices") public List<Services> getAllServices() {
	 * LOGGER.info("Services---> getAllServices() started."); Services service = new
	 * Services(110, "Kubernetes", "Priya M", "Premium", 105, 10000, 4,
	 * "assets/angular.jpg",
	 * "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s."
	 * ); services.add(service);
	 * 
	 * List<User> tutors = tutorsClientInterface.getUsers(); List<Course> courses =
	 * courseClientInterface.getCourses();
	 * 
	 * System.out.println(tutors.toString()); service = new
	 * Services(courses.get(0).getId(),courses.get(0).getName(),courses.get(0).
	 * getAuthor(),
	 * courses.get(0).getType(),courses.get(0).getDuration(),courses.get(0).getPrice
	 * (), courses.get(0).getRating(),courses.get(0).getImage(),courses.get(0).
	 * getDescription()); services.add(service);
	 * LOGGER.info("Services---> getAllServices() ended."); return services;
	 * 
	 * }
	 * 
	 * public List<Services> getMockservices(Throwable t){
	 * 
	 * Services service = new Services(110, "Kubernetes", "Priya M", "Premium", 105,
	 * 10000, 4, "assets/angular.jpg",
	 * "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s."
	 * ); services.add(service);
	 * 
	 * 
	 * List<Course> courses = courseClientInterface.getCourses(); service = new
	 * Services(courses.get(0).getId(),courses.get(0).getName(),courses.get(0).
	 * getAuthor(),
	 * courses.get(0).getType(),courses.get(0).getDuration(),courses.get(0).getPrice
	 * (), courses.get(0).getRating(),courses.get(0).getImage(),courses.get(0).
	 * getDescription()); services.add(service);
	 * 
	 * return services;
	 * 
	 * }
	 */

	@GetMapping("/kafka/services")
	public void pushDataToKafka() throws IOException {
		InputStream inputStream = Resources.getResource("people.json").openStream();
		String json = IOUtils.toString(inputStream);
		Type listType = new TypeToken<ArrayList<Person>>() {
		}.getType();
		List<Person> people = new Gson().fromJson(json, listType);
		/*
		 * give a start time and then run the time every minute and then generate a
		 * random number for HR and spo2
		 * 
		 * 
		 */
		// Date date = new Date();
		Calendar startTime = new Calendar.Builder().setDate(2023, Calendar.APRIL, 01).setTimeOfDay(0, 0, 0).build();

		Calendar endTime = Calendar.getInstance();
		Date todayDate = endTime.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:MM:SS");
		String strDate = formatter.format(todayDate);
		System.out.println(strDate);

		do {
			people.stream().forEach(p -> kafkaTemplate.send("persontopic", p));
			startTime.add(Calendar.MINUTE, 30);
			for (Person p : people) {
				if (p.getHr() == 72 && p.getSpo2() == 99) {
					p.setHr(p.getHr() + 1);
					p.setSpo2(p.getSpo2() - 1);
				} else if (p.getHr() == 73 && p.getSpo2() == 98) {
					p.setHr(p.getHr() + 1);
					p.setSpo2(p.getSpo2() - 1);
				} else {
					p.setHr(p.getHr() + 1);
					p.setSpo2(p.getSpo2() - 1);
				}
			}
			System.out.println(startTime.getTime().toLocaleString());
		} while (startTime.getTime().before(todayDate));

	}

	/*
	 * @PostMapping("/services") public ResponseEntity<Services>
	 * addServices(@RequestBody Services services) { this.services.add(services);
	 * return new ResponseEntity<>(services, HttpStatus.CREATED); }
	 */

	/*
	 * @GetMapping("/servicess/configurations") private String getProperties()
	 * throws JsonProcessingException { ObjectWriter ow = new
	 * ObjectMapper().writer().withDefaultPrettyPrinter(); MyProperties props = new
	 * MyProperties(myconfigurations.getMessage(),myconfigurations.getBuildversion()
	 * ,myconfigurations.getDescription(),myconfigurations.getLabel(),
	 * myconfigurations.getPort()); String jsonStr= ow.writeValueAsString(props);
	 * return jsonStr; }
	 */

}
