package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService { //인터페이스로 팀장에 제공하는 메서드

	public void register(BoardVO board); //등록

	public BoardVO get(Long bno); //검색

	public boolean modify(BoardVO board); //수정

	public boolean remove(Long bno); //제거
	
//	public List<BoardVO> getList(); //리스트화
	
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
}
