package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.BatchSize;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionInformation {

	private static final int COMMENT_MIN_LENGTH = 5;
	public static final int DESCRIPTION_MIN_LENGTH = 30;
	public static final int TITLE_MAX_LENGTH = 150;
	public static final int TITLE_MIN_LENGTH = 15;

	@Id
	@GeneratedValue
	private Long id;

	@Lob
	@Length(min = TITLE_MIN_LENGTH, max = TITLE_MAX_LENGTH, message = "question.errors.title.length")
	@NotEmpty(message = "question.errors.title.length")
	private String title;

	@Lob
	@Length(min = DESCRIPTION_MIN_LENGTH, message = "question.errors.description.length")
	@NotEmpty
	private String description;
	
	@NotNull(message = "question.errors.comment.not_null")
	@Length(min = COMMENT_MIN_LENGTH, message = "question.errors.comment.length")
	@NotEmpty(message = "question.errors.comment.length")
	@Type(type = "text")
	private String comment;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private User author;
	
	@NotNull
	private Date createdAt;;

	@BatchSize(size=25)
	@OrderColumn(name = "tag_order")
	@ManyToMany
	private List<Tag> tags = new ArrayList<>();
	
	@Lob
	private String markedDescription;
	
	@ManyToOne
	private Question question;
	
}
