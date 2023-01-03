package com.crecard.execption;

public class StatementIdNotFoundException extends RuntimeException {
	public StatementIdNotFoundException(String message) {
        super(message);
    }

}
