package com.example.demo.board.web;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.BoardVO;
import com.example.demo.board.searchVO1;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	//생성자 방식 의존성 주입
	final BoardMapper mapper;
	
	//목록페이지 이동
	@RequestMapping("/board/list")
	public String boardList(Model model, BoardVO vo, searchVO1 svo,Paging pvo){ 
		
		//페이징처리
		pvo.setPageUnit(5); // 데이터수
		pvo.setPageSize(3); //페이지번호
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		pvo.setTotalRecord(mapper.getCount(vo,svo));
		model.addAttribute("paging",pvo);
		
		model.addAttribute("boardList", mapper.getBoardList(vo, svo));
		return "board/list"; 
	}
	
	//등록처리
	@PostMapping("/inserts")
	public String inserts(BoardVO vo, MultipartFile photofile) throws IllegalStateException, IOException{
		if (photofile != null) {
			if (photofile.getSize() > 0) {
				// 파일 생성
				File file = new File("d:/upload", photofile.getOriginalFilename());
				// 파일 저장
				photofile.transferTo(file);
				vo.setImage(photofile.getOriginalFilename());
			}
		}
		int result = mapper.insertBoard(vo);
		if(result>0) {
			System.out.println("등록완료");
		}
		return "redirect:/board/list";
	}
	
	//등록페이지 이동
	@GetMapping("/board/insert")
	public void insert() {
		
	}
	
	//수정페이지 이동
	@GetMapping("/board/update")
	public void update() {
		
	}

	//수정처리
	@PostMapping("/updates")
	public String updates(BoardVO vo) {
		if(mapper.updateBoard(vo)>0) {
			System.out.println("수정완료");
		}
		
		return "redirect:/board/list";
	}
	
	//삭제처리
	@RequestMapping("/deletes/{boardNo}")
	public String deletes(@PathVariable String boardNo) {
		
		BoardVO vo = new BoardVO();  
		vo.setBoardNo(Integer.parseInt(boardNo));
		if(mapper.deleteBoard(vo) > 0) {
			System.out.println("삭제완료");
		};
		
		return "redirect:/board/list";
	}
	
	//상세조회
	@RequestMapping("/board/info/{boardNo}")
	public String info(@PathVariable String boardNo, Model model) {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(boardNo));
		model.addAttribute("board",mapper.getBoardInfo(vo));
		
		System.out.println("조회완료");
		return "board/info";
	}
}
