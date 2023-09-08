package com.poscodx.web.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {

	public static void forward(String path, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request
			.getRequestDispatcher("/WEB-INF/views/" + path + ".jsp")
			.forward(request, response);
	}
	
}
