package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.ReplyVO;

@Mapper
public interface ReplyMapper {
	public int deleteReply(Long rno); //삭제
	public int updateReply(ReplyVO reply); //수정
	
	//등록
	public int insertReply(ReplyVO vo);
	//목록출력
	public List<ReplyVO> getListWithPaging(ReplyVO vo, BSearchVO svo);
	public long getCount(ReplyVO vo);
}
