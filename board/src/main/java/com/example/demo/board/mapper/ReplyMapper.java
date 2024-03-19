package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;

@Mapper
public interface ReplyMapper {
	public int insertReply(ReplyVO vo);
	public ReplyVO readReply(Long rno);
	public int deleteReply(Long rno);
	public int updateReply(ReplyVO reply);
	public List<ReplyVO> getListWithPaging(BSearchVO svo, Long bno); 
}
