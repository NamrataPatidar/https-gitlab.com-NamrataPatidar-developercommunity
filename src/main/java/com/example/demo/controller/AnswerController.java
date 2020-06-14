/**
* @author Namrata Patidar - 747
* @version 1.0
* @since 14-Jun-2020
*/
package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Answer;
import com.example.demo.model.AnswerInformation;
import com.example.demo.model.LoggedUser;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.example.demo.repository.AnswerRepository;

/**
 * @author hasher
 *
 */
@RestController
public class AnswerController {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	private LoggedUser currentUser;
	
	@PostMapping("/add_answer")
	public ResponseEntity<?> addAnswer(Question question, String description) {
		User current = currentUser.getCurrent();
		Date date = new Date();	
		AnswerInformation information = new AnswerInformation(current.getId(),description, current, date, null, null);
		Answer answer  = new Answer(current.getId(), date, current, question, information, null, null, null);
		Answer ansObj = answerRepository.save(answer);
		return new ResponseEntity<Answer>(ansObj, HttpStatus.CREATED);
	}
	
	@PutMapping("/update_answer")
	public ResponseEntity<?> updateAnswer(Question question, String description){
		User current = currentUser.getCurrent();
		Date date = new Date();	
		AnswerInformation informationObj = new AnswerInformation(current.getId(), description, current, date, null, null);
		Answer answer  = new Answer(current.getId(), date, current, question, informationObj, null, null, null); 
		Answer ansObj = answerRepository.save(answer);
		return new ResponseEntity<Answer>(ansObj, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/answer_question")
	public ResponseEntity<?> deleteQuestion(Answer answer) {
		if (answer.getAuthor().equals(currentUser.getCurrent())) {
			answerRepository.delete(answer);
		}
		return new ResponseEntity<Answer>(HttpStatus.OK);
	}

}
