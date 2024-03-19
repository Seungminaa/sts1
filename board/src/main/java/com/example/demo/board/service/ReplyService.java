package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo);
	public ReplyVO get(Long rno);
	public int modify(ReplyVO vo);
	public int remove(Long rno);
	public List<ReplyVO> getList(BSearchVO svo,Long bno);
}
