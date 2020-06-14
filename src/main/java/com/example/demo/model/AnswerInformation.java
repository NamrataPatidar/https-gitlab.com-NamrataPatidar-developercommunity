package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hasher
 *
 */
@SuppressWarnings("deprecation")
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AnswerInformation {

	@Id
	@GeneratedValue
	private Long id;

	@Lob
	@Length(min = 30)
	@NotEmpty
	private String description;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private User author;
	
	@NotNull
	private Date createdAt;

	@NotNull(message = "answer.errors.comment.not_null")
	@Length(min = 5, message = "answer.errors.comment.length")
	@NotEmpty(message = "answer.errors.comment.length")
	@Type(type = "text")
	private String comment;

	@ManyToOne
    private Answer answer;
	
}