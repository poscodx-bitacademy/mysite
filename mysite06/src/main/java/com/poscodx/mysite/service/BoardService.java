package com.poscodx.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.BoardRepository;
import com.poscodx.mysite.vo.BoardVo;

@Service
public class BoardService {
	private static final int LIST_SIZE = 5; //리스팅되는 게시물의 수
	private static final int PAGE_SIZE = 5; //페이지 리스트의 페이지 수
	
	@Autowired
	private BoardRepository boardRepository;
	
	public void addContents(BoardVo boardVo) {
		if(boardVo.getGroupNo() != null) {
			boardRepository.updateOrderNo(boardVo.getGroupNo(), boardVo.getOrderNo());
		}
		
		boardRepository.insert(boardVo);
	}
	
	public BoardVo getContents(Long no) {
		BoardVo boardVo = boardRepository.findByNo(no);
		
		if(boardVo != null) {
			boardRepository.updateHit(no);
		}
		
		return boardVo;
	}

	public BoardVo getContents(Long no, Long userNo) {
		BoardVo boardVo = boardRepository.findByNoAndUserNo(no, userNo);
		return boardVo;
	}
	
	public void modifyContents(BoardVo boardVo) {
		boardRepository.update(boardVo);
	}
	
	public void deleteContents(Long boardNo, Long userNo) {
		boardRepository.delete(boardNo, userNo);
	}
	
	public Map<String, Object> getContentsList(int currentPage, String keyword) {
		
		//1. 페이징을 위한 기본 데이터 계산
		int totalCount = boardRepository.getTotalCount(keyword); 
		int pageCount = (int)Math.ceil((double)totalCount / LIST_SIZE);
		int blockCount = (int)Math.ceil((double)pageCount / PAGE_SIZE);
		int currentBlock = (int)Math.ceil((double)currentPage / PAGE_SIZE);
		
		//2. 파라미터 page 값  검증
		if(currentPage > pageCount) {
			currentPage = pageCount;
			currentBlock = (int)Math.ceil((double)currentPage / PAGE_SIZE);
		}		
		
		if(currentPage < 1) {
			currentPage = 1;
			currentBlock = 1;
		}
		
		//3. view에서 페이지 리스트를 렌더링 하기위한 데이터 값 계산
		int beginPage = currentBlock == 0 ? 1 : (currentBlock - 1) * PAGE_SIZE + 1;
		int prevPage = (currentBlock > 1 ) ? (currentBlock - 1) * PAGE_SIZE : 0;
		int nextPage = (currentBlock < blockCount) ? currentBlock * PAGE_SIZE + 1 : 0;
		int endPage = (nextPage > 0) ? (beginPage - 1) + LIST_SIZE : pageCount;
		
		//4. 리스트 가져오기
		List<BoardVo> list = boardRepository.findAllByPageAndKeword(keyword, currentPage, LIST_SIZE);
		
		//5. 리스트 정보를 맵에 저장
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("totalCount", totalCount);
		map.put("listSize", LIST_SIZE);
		map.put("currentPage", currentPage);
		map.put("beginPage", beginPage);
		map.put("endPage", endPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("keyword", keyword);

		return map;
	}
}
