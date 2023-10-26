package com.poscodx.mysite.exception;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poscodx.mysite.dto.JsonResult;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Log logger = LogFactory.getLog(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public void handlerException(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		
		//0. 요청 구분
		//	json 요청: accept에 application/json (o) 
		//  html 요청: accept에 application/json (x)
		String accept = request.getHeader("accept");
		
		//1. 404 Error 처리
		if(e instanceof NoHandlerFoundException) {
			if(accept.matches(".*application/json.*")) {
				JsonResult jsonResult = JsonResult.fail("404 Not Found");
				String jsonString = new ObjectMapper().writeValueAsString(jsonResult);
				
				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType("application/json; charset=utf-8");
				
				OutputStream os = response.getOutputStream();
				os.write(jsonString.getBytes("utf-8"));
				
			} else {
				request
					.getRequestDispatcher("/WEB-INF/views/error/404.jsp")
					.forward(request, response);
			}
			
			return;
		}
		
		//2. 로깅(Logging)
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		logger.error(errors.toString());
		
		//3. 사과 페이지
		if(accept.matches(".*application/json.*")) {
			JsonResult jsonResult = JsonResult.fail(errors.toString());
			String jsonString = new ObjectMapper().writeValueAsString(jsonResult);
			
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json; charset=utf-8");
			
			OutputStream os = response.getOutputStream();
			os.write(jsonString.getBytes("utf-8"));
		} else {
			request.setAttribute("errors", errors.toString());
			request
				.getRequestDispatcher("/WEB-INF/views/error/exception.jsp")
				.forward(request, response);
		}
	}
}
