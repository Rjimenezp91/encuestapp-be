package com.tresIt.encuestapp.be.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresIt.encuestapp.be.entity.Survey;
import com.tresIt.encuestapp.be.repository.ISurveyRepository;
import com.tresIt.encuestapp.be.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService {

	@Autowired
	private ISurveyRepository surveyRepository;

	@Override
	public List<Survey> getAll() {
		return surveyRepository.findAll();

	}

	@Override
	public Survey save(Survey survey) {
		Survey saveSurvey = new Survey();
		if (!survey.equals(null)) {

			saveSurvey.setChoice(survey.getChoice());
			saveSurvey.setEmail(survey.getEmail());

			return surveyRepository.save(saveSurvey);
		}

		return null;
	}

}
