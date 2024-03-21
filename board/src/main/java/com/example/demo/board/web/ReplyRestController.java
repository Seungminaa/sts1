package com.example.demo.board.web;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReplyRestController {
	
	final ReplyService replyService;
	
	//댓글 목록
	@GetMapping("/ajax/rList")
	public Map<String,Object> replyList(ReplyVO vo, BSearchVO svo,Paging pvo){ 
		
		//페이징처리
		pvo.setPageUnit(5); // 데이터수
		pvo.setPageSize(3); //페이지번호
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		
		Map<String, Object> map = replyService.getList(vo, svo);
		
		pvo.setTotalRecord((long)map.get("count"));
		map.put("paging", pvo);
		
		return map;
	}
	
	//댓글등록
	//formData
	@PostMapping("/ajax/reply")
	public ReplyVO save(ReplyVO vo) { 
		replyService.register(vo);
		return vo;
	}
	
	//댓글수정
	@PostMapping("/ajax/update")
	public ReplyVO update(ReplyVO vo) {
		replyService.modify(vo);
		return vo;
	}
	
	//댓글삭제
	@GetMapping("/ajax/delete")
	public ReplyVO delete(ReplyVO vo) {
		replyService.remove(vo.getRno());
		return vo;
	}

}
