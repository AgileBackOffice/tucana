/**
 * 
 */
package org.agilebackoffice.wafe.domain;


/**
 * @author kamann
 *
 */
public class Comment {
	private String name;
	private String email;
	private String comment;
	private Constellation constellation;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the constellation
	 */
	public Constellation getConstellation() {
		return constellation;
	}

	/**
	 * @param constellation
	 *            the constellation to set
	 */
	public void setConstellation(Constellation constellation) {
		this.constellation = constellation;
	}
}
