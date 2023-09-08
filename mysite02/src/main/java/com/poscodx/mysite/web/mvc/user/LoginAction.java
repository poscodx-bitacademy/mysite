package com.poscodx.mysite.web.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.mysite.dao.UserDao;
import com.poscodx.mysite.vo.UserVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo userVo = new UserDao().findByEmailAndPassword(email, password);
		
		// 로그인 실패
		if(userVo == null) {
			request.setAttribute("email", email);
			WebUtil.forward("user/loginform", request, response);
			return;
		}
		
		/* 로그인 처리 */
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", userVo);
		
		// redirect
		response.sendRedirect(request.getContextPath());
	}

}
