package org.zerock.domain;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class ReplyPageDTO {
	
	private int replyCnt;
	
	private List<ReplyVO> list;
}
