/**
* @author Namrata Patidar - 747
* @version 1.0
* @since 14-Jun-2020
*/
package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@NoArgsConstructor
@AllArgsConstructor
public class Community {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	@NotEmpty
	private String name;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User author;
	
}
