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
import javax.persistence.JoinTable;
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
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private Date createdAt;

	@ManyToOne
	private User author;
	
	@ManyToOne
	private Question question;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@NotNull
	private AnswerInformation information = null;
	
	@NotNull
	private Date lastUpdatedAt;

	@ManyToOne
	private User lastTouchedBy = null;

	@OneToMany(mappedBy="answer")
	private List<AnswerInformation> history= new ArrayList<>();
	
	@JoinTable(name="Answer_Votes")
    @OneToMany
    private final List<Vote> votes = new ArrayList<>();
}
