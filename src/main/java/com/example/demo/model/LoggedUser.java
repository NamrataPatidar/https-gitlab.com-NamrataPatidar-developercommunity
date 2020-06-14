/**
* @author Namrata Patidar - 747
* @version 1.0
* @since 14-Jun-2020
*/
package com.example.demo.model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hasher
 *
 */

public class LoggedUser {

	private final User user;
	@SuppressWarnings("unused")
	private final HttpServletRequest request;

	public LoggedUser(User user, HttpServletRequest request) {
		this.user = user;
		this.request = request;
	}

	public User getCurrent() {
		return isLoggedIn() ? user : null;
	}

	public boolean isModerator() {
		return isLoggedIn() ? true : false;
	}

	public boolean isLoggedIn() {
		return user != null;
	}

}