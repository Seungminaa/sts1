package com.example.demo.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertReply(vo);
	}

	@Override
	public Map<String, Object> getList(ReplyVO vo, BSearchVO svo) {
		Map<String,Object> map = new HashMap<String, Object>();

		map.put("data", mapper.getListWithPaging(vo, svo));
		map.put("count", mapper.getCount(vo));
		return map;
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateReply(vo);
	}

	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		return mapper.deleteReply(rno);
	}
	
}
