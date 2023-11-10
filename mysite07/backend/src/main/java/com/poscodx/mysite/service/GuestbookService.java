package com.poscodx.mysite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.GuestbookRepository;
import com.poscodx.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	final GuestbookRepository guestbookRepository;

	public GuestbookService(GuestbookRepository guestbookRepository) {
		this.guestbookRepository = guestbookRepository;
	}

	public List<GuestbookVo> getContentsList(Long no) {
		return guestbookRepository.findAll(no);
	}
	
	public boolean deleteContents(Long no, String password) {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		
		return guestbookRepository.delete(vo);
	}

	public boolean addContents(GuestbookVo vo) {
		return guestbookRepository.insert(vo);
	}
}
