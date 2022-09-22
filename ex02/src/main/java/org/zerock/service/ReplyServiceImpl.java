package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service //해당 클래스를 루트 컨테이너 빈객체로 생성(서비스 레이어, 내부에서 자바 로직을 처리)
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService{

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
   
   @Override
   public int register(ReplyVO vo) {
      
      log.info("register............." + vo);
      
      return mapper.insert(vo);
   }

   @Override
   public ReplyVO get(Long rno) {
      
      log.info("Get.............." + rno) ;
      return mapper.read(rno);
   }

   @Override
   public int modify(ReplyVO vo) {
      
      log.info("modify............" + vo); 
      return mapper.update(vo);
   }

   @Override
   public int remove(Long rno) {
      
      log.info("remove............" + rno); 
      return mapper.delete(rno);
   }
   
   @Override
   public List<ReplyVO> getList(Criteria cri, Long bno) {
      
      log.info("get Reply List of a Board " + bno);
      
      return mapper.getListWithPaging(cri,bno);
   }

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {

		return new ReplyPageDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(cri, bno));
	}
  
}