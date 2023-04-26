package com.ezlearner.services.controllers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ConfigurationProperties(prefix = "services")
public class Myconfigurations {

	private String message;
	private int buildversion;
	private String description;
	private String label;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getBuildversion() {
		return buildversion;
	}
	public void setBuildversion(int buildversion) {
		this.buildversion = buildversion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	private int port;
}
