package com.poscodx.mysite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.GalleryRepository;
import com.poscodx.mysite.vo.GalleryVo;

@Service
public class GalleryService {
	private final GalleryRepository galleryRepository;

	public GalleryService(GalleryRepository galleryRepository) {
		this.galleryRepository = galleryRepository;
	}

	public List<GalleryVo> getGalleryImages() {
		return galleryRepository.findAll();
	}
	
	public Boolean deleteGalleryImage(Long no) {
		return galleryRepository.delete(no);
	}
	
	public Boolean addGalleryImage(GalleryVo vo) {
		return galleryRepository.insert(vo);
	}
}
