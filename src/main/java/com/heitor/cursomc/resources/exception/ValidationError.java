package com.heitor.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessege> errors = new ArrayList<>();

	public ValidationError(Integer codStatus, String status, String error, Long timestamp) {
		super(codStatus, status, error, timestamp);
	}

	public List<FieldMessege> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessege(fieldName, message));
	}

	
}
