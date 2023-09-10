package com.douzone.mysite.web.mvc.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;


public class DeleteFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MvcUtil.forward("guestbook/deleteform", request, response);
	}
}
