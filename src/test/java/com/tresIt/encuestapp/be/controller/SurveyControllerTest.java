package com.tresIt.encuestapp.be.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tresIt.encuestapp.be.entity.Survey;
import com.tresIt.encuestapp.be.service.ISurveyService;

@DataJpaTest
public class SurveyControllerTest {

	@InjectMocks
	private SurveyController surveyController;

	@Mock
	private ISurveyService surveyService;

	public static final String TEST_CHOICE = "Jazz";
	public static final String TEST_EMAIL = "test@test.cl";
	public static final String STATUS_ERROR = "ERROR 404";
	public static final String STATUS_CREATED = "CREATED 201";
	public static final String STATUS_CONFLICT = "CONFLICT 409";

	@Test
	public void getAllSurveys() {
		List<Survey> surveyList = new ArrayList<>();
		Survey testSurvey = new Survey();
		testSurvey.setChoice(TEST_CHOICE);
		testSurvey.setEmail(TEST_EMAIL);
		surveyList.add(testSurvey);

		Mockito.when(surveyService.getAll()).thenReturn(surveyList);
		ResponseEntity<List<Survey>> response = surveyController.getAll();
		assertNotNull(response);

	}

	@Test
	public void getAllSurveysNull() {

		Mockito.when(surveyService.getAll()).thenReturn(null);
		ResponseEntity<List<Survey>> response = surveyController.getAll();
		assertTrue(STATUS_ERROR, HttpStatus.NOT_FOUND.equals(response.getStatusCode()));

	}

	@Test
	public void saveSurvey() {
		Survey testSurvey = new Survey();
		testSurvey.setChoice(TEST_CHOICE);
		testSurvey.setEmail(TEST_EMAIL);

		Mockito.when(surveyService.save(testSurvey)).thenReturn(testSurvey);
		ResponseEntity<Survey> response = surveyController.save(testSurvey);
		assertTrue(STATUS_CREATED, HttpStatus.CREATED.equals(response.getStatusCode()));

	}

	@Test
	public void saveSurveyError() {
		Survey testSurvey = new Survey();
		testSurvey.setChoice(TEST_CHOICE);
		testSurvey.setEmail(TEST_EMAIL);

		Mockito.when(surveyService.save(testSurvey)).thenReturn(null);
		ResponseEntity<Survey> response = surveyController.save(testSurvey);
		assertTrue(STATUS_CONFLICT, HttpStatus.CONFLICT.equals(response.getStatusCode()));

	}
}
