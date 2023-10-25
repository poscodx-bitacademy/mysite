package com.poscodx.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poscodx.mysite.dto.JsonResult;
import com.poscodx.mysite.service.UserService;
import com.poscodx.mysite.vo.UserVo;

@RestController("userApiController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public JsonResult get(
		@RequestParam(value="email", required=true, defaultValue="") String email) {
		UserVo vo = userService.getUser(email);
		return JsonResult.success(vo);
	}
}
