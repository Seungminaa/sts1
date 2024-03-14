package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BoardVO;
import com.example.demo.board.searchVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getBoardList(BoardVO vo, searchVO svo);
	BoardVO getBoardInfo(BoardVO vo);
	int insertBoard(BoardVO vo);
	int deleteBoard(BoardVO vo);
	int updateBoard(BoardVO vo);
}
