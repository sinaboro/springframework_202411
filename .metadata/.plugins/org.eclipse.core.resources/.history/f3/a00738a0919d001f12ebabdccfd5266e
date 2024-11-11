package org.zerock.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;

	
	@Test
	public void testGetList() {
		mapper.getList().forEach(list-> log.info(list));
	}
	
	@Test
	public void testInsert() {
//		BoardVO board = new BoardVO();
//		
//		board.setTitle("새로 작성하는 글3");
//		board.setContent("새로작성하는 내용3");
//		board.setWriter("newbie2");
//		
//		mapper.insertSelectKey(board);
//		
//		log.info(board);
	}
	
	@Test
	public void testRead() {
		Long bno = 2L;
		
		BoardVO boardVO = mapper.read(bno);
		log.info(boardVO);
	}
	
	@Test
	public void testDelete() {

		int result = mapper.delete(6L);
		
		log.info("result : " + result);
	}
	
	@Test
	public void testUpdate() {
		
		Long bno = 7L;
		
		BoardVO vo = mapper.read(bno);
		
		vo.setTitle("수정 제목");
		vo.setContent("수정 내용");
		vo.setWriter("수정자");
		
		int result = mapper.update(vo);
		log.info(result);
		
		
	}
}



















