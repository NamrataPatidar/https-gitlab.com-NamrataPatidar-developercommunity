/**
* @author Namrata Patidar - 747
* @version 1.0
* @since 14-Jun-2020
*/
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Answer;

/**
 * @author hasher
 *
 */
public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
