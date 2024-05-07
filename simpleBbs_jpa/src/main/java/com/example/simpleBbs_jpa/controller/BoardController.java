package com.example.simpleBbs_jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.simpleBbs_jpa.entity.Board;
import com.example.simpleBbs_jpa.entity.BoardDto;
import com.example.simpleBbs_jpa.entity.User;
import com.example.simpleBbs_jpa.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardRepository boardRepository;
	
	@RequestMapping("/main")
	public void main(Model model) {
		List<Board> list = boardRepository.findAll();
		List<BoardDto> blist = new ArrayList<>();
		for(Board board : list) {
			Long bno = board.getBno();
			String title = board.getTitle();
			String content = board.getContent();
			String writer = board.getUser().getUsername();
			
			BoardDto boardDto = new BoardDto(bno, title, content, writer);
			blist.add(boardDto);
			
		}
		model.addAttribute("list", blist);
	}
	
	@RequestMapping("/regBoard")
	public void regBoard() {
		System.out.println("regBoard.........Form..");
	}
	
	@RequestMapping("/reg")
	public String reg(BoardDto boardDto) {
		Board board = new Board(boardDto.getBno(), boardDto.getTitle(), boardDto.getContent(), new User(boardDto.getWriter()));
		Board result = boardRepository.save(board);
		System.out.println("result : " + result);
		
		return "redirect:/board/main";
	}
}
