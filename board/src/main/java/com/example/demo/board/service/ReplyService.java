package com.example.demo.board.service;

import java.util.List;
import java.util.Map;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo); //등록
	public int modify(ReplyVO vo); //수정
	public int remove(Long rno); //삭제
	public Map<String, Object> getList(ReplyVO vo,BSearchVO svo);
	
}
