/**
* @author Namrata Patidar - 747
* @version 1.0
* @since 14-Jun-2020
*/
package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String designation;
	
	private String country;
	
	@OneToMany
	private List<Community> communitites = new ArrayList<Community>();
	
	@OneToMany
	private List<Tag> tags = new ArrayList<Tag>();	

}
