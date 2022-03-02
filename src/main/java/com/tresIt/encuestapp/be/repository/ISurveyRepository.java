package com.tresIt.encuestapp.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tresIt.encuestapp.be.entity.Survey;

public interface ISurveyRepository extends JpaRepository<Survey, Long>{

}
