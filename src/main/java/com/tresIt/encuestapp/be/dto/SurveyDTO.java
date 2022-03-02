package com.tresIt.encuestapp.be.dto;

public class SurveyDTO {

	private Long id;
	private String email;
	private String choice;
	
	public SurveyDTO(Long id, String email, String choice) {
		super();
		this.id = id;
		this.email = email;
		this.choice = choice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	
}
