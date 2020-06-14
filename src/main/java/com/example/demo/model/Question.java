/**
* @author Namrata Patidar - 747
* @version 1.0
* @since 14-Jun-2020
*/
package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hasher
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@NotNull
	private QuestionInformation information = null;
	
	@NotNull
	private Date createdAt;

	@NotNull
	private Date lastUpdatedAt;

	@ManyToOne
	private User lastTouchedBy = null;

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Answer solution;

	@ManyToOne(fetch = FetchType.EAGER)
	private User author;
	
	@OneToMany(mappedBy = "question")
	private final List<Answer> answers = new ArrayList<>();

}
