package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service //해당 클래스를 루트 컨테이너 빈객체로 생성(서비스 레이어, 내부에서 자바 로직을 처리)
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듬
public class BoardServiceImpl implements BoardService{

   private BoardMapper mapper;
   
   @Override
   public void register(BoardVO board) {
      
      log.info("register............." + board);
      
      mapper.insertSelectKey(board);
   }

   @Override
   public BoardVO get(Long bno) {
      
      log.info("Get.............." + bno) ;
      return mapper.read(bno);
   }

   @Override
   public boolean modify(BoardVO board) {
      
      log.info("modify............" + board); 
      return mapper.update(board) == 1 ;
   }

   @Override
   public boolean remove(Long bno) {
      
      log.info("remove............" + bno); 
      return mapper.delete(bno) == 1 ;
   }

//   @Override
//   public List<BoardVO> getList() {
//      
//      log.info("getList.................");
//      
//      return mapper.getList();
//   }
   
   @Override
   public List<BoardVO> getList(Criteria cri) {
      
      log.info("get List with criteria: " + cri);
      
      return mapper.getListWithPaging(cri);
   }
   
   @Override
   public int getTotal(Criteria cri) {
      
      log.info("get total count");
      return mapper.getTotalCount(cri);
   }

}