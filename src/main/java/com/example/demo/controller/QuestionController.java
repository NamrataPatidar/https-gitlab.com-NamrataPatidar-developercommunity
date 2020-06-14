/**
* @author Namrata Patidar - 747
* @version 1.0
* @since 14-Jun-2020
*/
package com.example.demo.controller;

/**
 * @author hasher
 *
 */
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoggedUser;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionInformation;
import com.example.demo.model.User;
import com.example.demo.repository.QuestionRepository;

@RestController
public class QuestionController {

	@Autowired
	private QuestionRepository questions;
	
	private LoggedUser currentUser;
	 

	@PostMapping("/add_question")
	public ResponseEntity<?> newQuestion(String title, String description, String comment) {
		//getting the current logged user
		User user = currentUser.getCurrent();
		Date date = new Date();	 
		
		QuestionInformation information = new QuestionInformation(null, title, description, comment, user, date, null, null, null);		
		Question question = new Question(null, information, date, date, null, null, user);
		Question questionObj = questions.save(question);
		return new ResponseEntity<Question>(questionObj, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete_question")
	public ResponseEntity<?> deleteQuestion(Question question) {
		if (question.getAuthor().equals(currentUser.getCurrent())) {
			questions.delete(question);
		}
		return new ResponseEntity<Question>(HttpStatus.OK);
	}

}