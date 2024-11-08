package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;

@Service
public interface BoardService {

	public void register(BoardVO vo);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO vo);
	
	public boolean remove(Long bno);
	
	public List<BoardVO> getList();
}
