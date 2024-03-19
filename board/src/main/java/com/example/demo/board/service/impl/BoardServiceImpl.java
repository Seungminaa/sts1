package com.example.demo.board.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.BoardVO;
import com.example.demo.board.BSearchVO;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired ) //@Autowired
	BoardMapper boardMapper;

	@Override
	public Map<String, Object> getBoardList(BoardVO boardVO, BSearchVO svo) {
		Map<String,Object> map = new HashMap<String, Object>();
		// 리스트와 전체건수
		map.put("data", boardMapper.getBoardList(boardVO, svo));
		map.put("count", boardMapper.getCount(boardVO, svo));
		return map;
	}

	@Override
	public BoardVO getBoardInfo(int boardNo) {
		// TODO Auto-generated method stub
		return boardMapper.getBoardInfo(boardNo);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardMapper.insertBoard(boardVO);
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return boardMapper.deleteBoard(boardNo);
	}

	@Override
	public long getCount(BoardVO boardVO, BSearchVO svo) {
		// TODO Auto-generated method stub
		return boardMapper.getCount(boardVO, svo);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardMapper.updateBoard(boardVO);
	}

}
