package com.poscodx.mysite.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.mysite.dto.JsonResult;
import com.poscodx.mysite.service.FileUploadService;
import com.poscodx.mysite.service.GalleryService;
import com.poscodx.mysite.vo.GalleryVo;

@RestController
@RequestMapping("/api/gallery")
public class GalleryController {
	
	private final GalleryService galleryService;
	private final FileUploadService FileUploadService;

	public GalleryController(FileUploadService FileUploadService, GalleryService galleryService) {
		this.FileUploadService = FileUploadService;
		this.galleryService = galleryService;
	}

	@GetMapping("")
	public ResponseEntity<JsonResult> index() {
		return ResponseEntity.status(HttpStatus.OK).body(JsonResult.success(galleryService.getGalleryImages()));
	}
	
	@PostMapping
	public ResponseEntity<JsonResult> upload(MultipartFile file, GalleryVo galleyVo) {
		galleyVo.setImageUrl(FileUploadService.restoreImage(file));
		galleryService.addGalleryImage(galleyVo);

		return ResponseEntity.status(HttpStatus.OK).body(JsonResult.success(galleyVo));
	}
	
	@DeleteMapping(value="/{no}")
	public ResponseEntity<JsonResult> delete(@PathVariable("no") Long no) {
		galleryService.deleteGalleryImage(no);
		return ResponseEntity.status(HttpStatus.OK).body(JsonResult.success(Map.of("no", no)));
	}
}
