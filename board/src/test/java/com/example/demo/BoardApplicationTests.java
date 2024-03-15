package com.example.demo;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.BoardVO;
import com.example.demo.board.searchVO1;
import com.example.demo.board.mapper.BoardMapper;


@SpringBootTest
class BoardApplicationTests {

	@Autowired
	BoardMapper mapper;
	
	//@Test
	public void 게시글검색() {
		BoardVO vo = new BoardVO();
		searchVO1 svo = new searchVO1();
		
		List<BoardVO> list = mapper.getBoardList(vo,svo);
		for(BoardVO bod : list) {
			System.out.println("제목 : " + bod.getTitle());
			System.out.println("내용 : "+ bod.getContent());
			System.out.println("사진 : "+ bod.getImage());
			System.out.println("작성자 : "+ bod.getWriter());
			System.out.println("클릭수 : "+ bod.getClickCnt());
			System.out.println("작성일 : "+ bod.getWriteDate());
		}
	}
	
	//@Test
	public void 게시글단건조회() {
		
		BoardVO vo = new BoardVO();
		vo.setBoardNo(5);
		BoardVO vo1 = mapper.getBoardInfo(vo);
		
		System.out.println(vo1);
	}
	
	//@Test
	public void 게시글등록() {
		BoardVO vo = BoardVO.builder().writer("제발").title("이거").image("저거").clickCnt(2).content("저거").writeDate(new Date()).build();
		int a = mapper.insertBoard(vo);
		System.out.println(a);
	}
	
	//@Test
	public void 게시글삭제() {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(5);
		
		int f = mapper.deleteBoard(vo);
		System.out.println(f);
	}
	
	@Test
	public void 게시글수정() {
		BoardVO vo = BoardVO.builder().boardNo(6).writer("제발").title("이거").image("저거").clickCnt(2).content("저거").writeDate(new Date()).build();
		
		int w = mapper.updateBoard(vo);
		
		System.out.println(w);
	}

}
