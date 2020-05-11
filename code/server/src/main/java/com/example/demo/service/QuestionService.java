package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.annotation.processing.SupportedAnnotationTypes;

@Service
public interface QuestionService {
    String insert(String courseId,String que);
}
