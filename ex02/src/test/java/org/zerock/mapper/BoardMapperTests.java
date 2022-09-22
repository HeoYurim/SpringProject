package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 생성한 글 제목");
		board.setContent("새로 생성한 글 내용");
		board.setWriter("user01"); //객체에 내용을 입력하는 세터
		
		mapper.insert(board); //객체의 내용을 처리하는 메서드
		
		log.info(board); //객체를 출력하는 로그
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 생성한 글 제목 SelectKey사용");
		board.setContent("새로 생성한 글 내용 SelectKey사용");
		board.setWriter("user02"); //객체에 내용을 입력하는 세터
		
		mapper.insertSelectKey(board); //객체의 내용을 처리하는 메서드
		
		log.info(board); //객체를 출력하는 로그
	}
	
	@Test
	public void testRead() {
		
		BoardVO board = mapper.read(7L); //bno가 7번에 해당하는 게시물 내용을 불러온다
		
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		
		log.info("DELETE COUNT : " + mapper.delete(3L));
	}
	
	@Test
	public void testUpdate() {

		BoardVO board = new BoardVO();
		// 실행전 존재하는 번호인지 확인할 것
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user03");

		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		//10씩 3페이지
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board.getBno()));
	}
}
