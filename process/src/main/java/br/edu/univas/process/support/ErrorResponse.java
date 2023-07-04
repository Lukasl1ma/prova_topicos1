package br.edu.univas.process.support;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
	private String message;
	private Integer status;
	private Date date;

}
