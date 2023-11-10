package com.poscodx.mysite.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poscodx.mysite.dto.JsonResult;
import com.poscodx.mysite.service.GuestbookService;
import com.poscodx.mysite.vo.GuestbookVo;

@RestController
@RequestMapping("/api/guestbook")
public class GuestbookController {
	private final GuestbookService guestbookService;

	public GuestbookController(GuestbookService guestbookService) {
		this.guestbookService = guestbookService;
	}

	@GetMapping("")
	public ResponseEntity<JsonResult> list(@RequestParam(value="no", required=true, defaultValue="0") Long startNo) {
		return ResponseEntity.status(HttpStatus.OK).body(JsonResult.success(guestbookService.getContentsList(startNo)));
	}

	@PostMapping("")
	public ResponseEntity<JsonResult> add(@RequestBody GuestbookVo vo) {
		guestbookService.addContents(vo);
		vo.setPassword("");		
		return ResponseEntity.status(HttpStatus.OK).body(JsonResult.success(vo));
	}

	@DeleteMapping("/{no}")
	public ResponseEntity<JsonResult> delete(@PathVariable("no") Long no, @RequestParam(value="password", required=true, defaultValue="") String password) {
		Boolean result = guestbookService.deleteContents(no, password);		
		return ResponseEntity.status(HttpStatus.OK).body(JsonResult.success(result ? no : null));
	}
}