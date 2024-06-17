package com.app.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7660205402977590967L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
