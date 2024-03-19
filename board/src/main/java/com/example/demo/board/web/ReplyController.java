package com.example.demo.board.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReplyController {
	
	final ReplyService replyService;
	
	//댓글 등록
	@PostMapping(value = "/new",consumes = "application/json",produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		int insertCount = replyService.register(vo);
		
		return insertCount == 1 ? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	//댓글 목록
//	@GetMapping(value = "/pages/{bno}/{page}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
//	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page,@PathVariable("bno") Long bno){
//		
//		//페이징처리
//			Paging pvo = new Paging();
//			BSearchVO svo = new BSearchVO();
//				pvo.setPageUnit(5); // 데이터수
//				pvo.setPageSize(3); //페이지번호
//				svo.setStart(pvo.getFirst());
//				svo.setEnd(pvo.getLast());
//				
//				return new ResponseEntity<>(replyService.getList(pvo, bno),HttpStatus.OK);
//	}
}
