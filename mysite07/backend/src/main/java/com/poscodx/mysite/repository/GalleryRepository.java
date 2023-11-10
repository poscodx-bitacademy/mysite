package com.poscodx.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.mysite.vo.GalleryVo;

@Repository
public class GalleryRepository {
	private final SqlSession sqlSession;

	public GalleryRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Boolean insert(GalleryVo vo) {
		return 1 == sqlSession.insert("gallery.insert", vo);
	}

	public Boolean delete(Long no) {
		return 1 == sqlSession.delete("gallery.delete", no);
	}

	public List<GalleryVo> findAll() {
		return sqlSession.selectList("gallery.findAll");
	}
}
