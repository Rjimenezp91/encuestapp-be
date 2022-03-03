package com.tresIt.encuestapp.be.service;

import java.util.List;
import com.tresIt.encuestapp.be.entity.Survey;

public interface ISurveyService {

	List<Survey> getAll();

	Survey save(Survey survey);
}
