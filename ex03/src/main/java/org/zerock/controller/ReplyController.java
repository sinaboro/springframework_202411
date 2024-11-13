package org.zerock.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

@RestController
@RequestMapping("/replies/")
@Log4j
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService service;

	@PostMapping(value = "/new", 
				consumes = MediaType.APPLICATION_JSON_VALUE,  //요청(json)
				produces = MediaType.TEXT_PLAIN_VALUE  //응답(String)
			)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("create........" + vo);
		
		int insertCount = service.register(vo);
		
		
		return insertCount == 1 
			 ?	new ResponseEntity<String>("success", HttpStatus.OK)
			 : 	new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);			
	};
	
	//http://localhost:8080/replies/pages/18/1
	@GetMapping(value = "/pages/{bno}/{page}", 
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable("bno") Long bno, @PathVariable("page") int page 
			){
		
		log.info("getList........bno : " + bno + ",page: " + page);
		Criterial cri = new Criterial(page, 10);
		
		List<ReplyVO> list = service.getList(cri, bno);
		
		return new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK);
	}
	
}
