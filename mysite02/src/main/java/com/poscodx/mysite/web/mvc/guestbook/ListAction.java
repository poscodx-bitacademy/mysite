package com.poscodx.mysite.web.mvc.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.GuestbookDao;
import com.poscodx.mysite.vo.GuestbookVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;


public class ListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestbookVo> list = new GuestbookDao().findAll();
		
		request.setAttribute("list", list);
		WebUtil.forward("guestbook/list", request, response);
	}
}
