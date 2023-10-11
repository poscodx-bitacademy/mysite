package com.poscodx.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.SiteRepository;
import com.poscodx.mysite.vo.SiteVo;

@Service
public class SiteService {
	@Autowired
	private SiteRepository sietRepository;

	public SiteVo getSite() {
		return sietRepository.find();
	}
	
	public void updateSite(SiteVo vo) {
		sietRepository.update(vo);
	}
}
