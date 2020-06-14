/**
* @author Namrata Patidar - 747
* @version 1.0
* @since 14-Jun-2020
*/
package com.example.demo.model;

/**
 * @author hasher
 *
 */
public enum VoteType {
	UP(1){
		@Override
		public String toString() {
			return "UpVote";
		}
	},
	DOWN(-1) {
		@Override
		public String toString() {
			return "DownVote";
		}
	};

	private final int value;

	private VoteType(int value) {
		this.value = value;
	}

	public int getCountValue() {
		return value;
	}
}