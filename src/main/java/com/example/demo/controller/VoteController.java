/**
* @author Namrata Patidar - 747
* @version 1.0
* @since 14-Jun-2020
*/
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoggedUser;
import com.example.demo.model.Vote;
import com.example.demo.model.VoteType;
import com.example.demo.repository.VoteRepository;

/**
 * @author hasher
 *
 */

@RestController
public class VoteController {
	
	@Autowired
	private VoteRepository voteRepository;
	
	private LoggedUser loggedUser;
	
	@PostMapping("/voteUp")
	public void voteUp(Long id, String type) {
		tryToVoteVotable(id, VoteType.UP);		
	}
	
	@PostMapping("/voteDown")
	public void voteDown(Long id, String type) {
		tryToVoteVotable(id, VoteType.DOWN);		
	}
	
	private void tryToVoteVotable(Long id, VoteType voteType) {
		try {
		    Vote vote = new Vote(loggedUser.getCurrent().getId(), loggedUser.getCurrent(), voteType);
		    voteRepository.save(vote);
		} catch (IllegalArgumentException e) {
		    //result.use(Results.http()).sendError(409);
		    return;
        }
	}

}
