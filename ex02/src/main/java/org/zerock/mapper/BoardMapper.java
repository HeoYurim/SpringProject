package org.zerock.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

   //@Select("select * from tbl_board where bno > 0")
   public List<BoardVO> getList();
   
   public List<BoardVO> getListWithPaging(Criteria cri);
   
   public void insert(BoardVO board);
   //insert만 처리되고 생성된 pk값을 알 필요 없는 경우
   
   public void insertSelectKey(BoardVO board);
   //insert만 처리되고 생성된 pk값을 알아야 하는 경우   
   
   public BoardVO read(Long bno);
   //폼에 입력된 검색 문자를 이용하여 bno를 이용한 검색을 사용
   
   public int delete(Long bno);
   //삭제시 삭제된 개수를 파악하기 위해서 int타입으로 결과를 얻는다.
   
   public int update(BoardVO board);
   
   public int getTotalCount(Criteria cri);
}

