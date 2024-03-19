package com.example.demo.board.service;

import java.util.Map;


import com.example.demo.board.BoardVO;
import com.example.demo.board.BSearchVO;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.searchVO;

public interface BoardService {

	 Map<String,Object> getBoardList(BoardVO vo,BSearchVO svo);
	 BoardVO getBoardInfo(int boardNo);
	 int insertBoard(BoardVO boardVO);
	 int deleteBoard(int boardNo);
	 int updateBoard(BoardVO vo);
	 
	 //board 갯수
	 public long getCount(BoardVO vo,BSearchVO svo);
}
