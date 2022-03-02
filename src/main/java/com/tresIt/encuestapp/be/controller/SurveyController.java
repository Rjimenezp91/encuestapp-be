package com.tresIt.encuestapp.be.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tresIt.encuestapp.be.entity.Survey;
import com.tresIt.encuestapp.be.service.ISurveyService;

@RestController
public class SurveyController {

	@Autowired
	private ISurveyService surveyService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Survey>> getAll(){
	List<Survey> surveyList = surveyService.getAll();
	if(Objects.nonNull(surveyList)) {
		return new ResponseEntity<List<Survey>>(surveyList, HttpStatus.OK);
	}
		return new ResponseEntity<List<Survey>>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Survey> save(@RequestBody Survey survey){
		Survey surveyResponse = surveyService.save(survey);
		if(Objects.nonNull(surveyResponse)) {
			return new ResponseEntity<Survey>(surveyResponse, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Survey>(HttpStatus.CONFLICT);
	}
}
