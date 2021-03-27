/**
 * 
 */
package com.hrs.exceptions;

/**
 * This class throws input exception if user enters bad input
 * 
 *
 */
public class InputFormatException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputFormatException(String s) {
		super(s);
	}

}
