package com.poscodx.mysite.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.servlet.NoHandlerFoundException;

import com.poscodx.mysite.dto.JsonResult;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public String handlerNoHandlerFoundException(Exception e) {
		return "index";
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<JsonResult> handlerException(Exception e) {
		// 1. 로깅(logging)
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		log.error(errors.toString());
		
		// 2. JSON 응답
		return ResponseEntity.status(HttpStatus.OK).body(JsonResult.fail(errors.toString()));
	}
}

