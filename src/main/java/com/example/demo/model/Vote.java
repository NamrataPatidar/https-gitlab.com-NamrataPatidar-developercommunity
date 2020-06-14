/**
* @author Namrata Patidar - 747
* @version 1.0
* @since 14-Jun-2020
*/
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Vote {
	
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private User author;
    
    @Enumerated(EnumType.STRING)
    private VoteType type;
}