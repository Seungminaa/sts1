package com.example.demo.board.web;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.BoardVO;
import com.example.demo.board.BSearchVO;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	//생성자 방식 의존성 주입
	final BoardService bService;
	
	// board 목록페이지 이동
	@RequestMapping("/board/bList")
	public String boardList(Model model, BoardVO vo, BSearchVO svo,Paging pvo){ 
		
		//페이징처리
		pvo.setPageUnit(5); // 데이터수
		pvo.setPageSize(3); //페이지번호
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		
		Map<String, Object> map = bService.getBoardList(vo, svo);
		
		pvo.setTotalRecord((long)map.get("count"));
		model.addAttribute("paging",pvo);
		
		model.addAttribute("boardList", map.get("data"));
		return "board/bList";
	}
	
	//상세조회
	@RequestMapping("/board/bInfo/{boardNo}")
	public String boardInfo(@PathVariable String boardNo, Model model) {
		model.addAttribute("board",bService.getBoardInfo(Integer.parseInt(boardNo)));
		
		System.out.println("조회완료");
		return "board/bInfo";
	}
	
	//수정처리
	@PostMapping("/board/bUpdate")
	public String updates(BoardVO vo) {
		if(bService.updateBoard(vo)>0) {
			System.out.println("수정완료");
		}
		
		return "redirect:/board/bList";
	}
	
	//삭제처리
	@RequestMapping("/board/bDelete/{boardNo}")
	public String deletes(@PathVariable String boardNo) {
		
		if(bService.deleteBoard(Integer.parseInt(boardNo)) > 0) {
			System.out.println("삭제완료");
		};
		
		return "redirect:/board/bList";
	}
	
	//등록페이지 이동
	@GetMapping("/board/bInsert")
	public void bInsert() {
		
	}
	
	
	//등록처리
	@PostMapping("/board/bInsert")
	public String inserts(BoardVO vo, MultipartFile photofile) throws IllegalStateException, IOException{
		if (photofile != null) {
			if (photofile.getSize() > 0) {
				// 파일 생성
				File file = new File("c:/upload", photofile.getOriginalFilename());
				// 파일 저장
				photofile.transferTo(file);
				vo.setImage(photofile.getOriginalFilename());
			}
		}
		int result = bService.insertBoard(vo);
		if(result>0) {
			System.out.println("등록완료");
		}
		return "redirect:/board/bList";
	}
	
}
