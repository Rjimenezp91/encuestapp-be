package com.tresIt.encuestapp.be.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tresIt.encuestapp.be.entity.Survey;
import com.tresIt.encuestapp.be.repository.ISurveyRepository;

@DataJpaTest
public class SurveyServiceImplTest {

	@InjectMocks
	private SurveyServiceImpl surveyServiceImpl;

	@Mock
	private ISurveyRepository surveyRepository;

	List<Survey> surveyList = new ArrayList<>();
	Survey survey = new Survey();

	public static final String IS_EMPTY = "IS EMPTY";

	@Test
	public void getAllSurveys() {

		Mockito.when(surveyRepository.findAll()).thenReturn(surveyList);
		List<Survey> responseList = surveyServiceImpl.getAll();
		assertTrue(IS_EMPTY, responseList.isEmpty());
	}

	@Test
	public void saveSurvey() {

		surveyServiceImpl.save(survey);
		verify(surveyRepository).save(Mockito.any());
	}

	@Test
	public void saveSurveyNull() {

		Survey response = surveyServiceImpl.save(survey);
		assertNull("NULL", response);
	}
}
