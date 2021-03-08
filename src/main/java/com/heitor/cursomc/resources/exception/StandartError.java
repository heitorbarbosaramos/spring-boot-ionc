package com.heitor.cursomc.resources.exception;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class StandartError implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer codStatus;
	private String status;
	private String error;
	private Long timestamp;
	private String date;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public StandartError() {
	}

	public StandartError(Integer codStatus, String status, String error, Long timestamp) {
		super();
		this.codStatus = codStatus;
		this.status = status;
		this.error = error;
		this.timestamp = timestamp;
		date = sdf.format(this.timestamp);
	}

	public Integer getCodStatus() {
		return codStatus;
	}

	public void setCodStatus(Integer codStatus) {
		this.codStatus = codStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
