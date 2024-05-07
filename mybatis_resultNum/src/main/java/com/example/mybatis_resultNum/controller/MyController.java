package com.example.mybatis_resultNum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mybatis_resultNum.dao.ISimpleBbsDao;
import com.example.mybatis_resultNum.dto.SimpleBbsDto;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MyController {
	
	@Autowired
	ISimpleBbsDao dao;
	
	@RequestMapping("/")
	public String root() {
		log.info("root..........");
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public void list(Model model) {
		log.info("list..........");
		model.addAttribute("total", dao.countBbs());
		model.addAttribute("list", dao.listDao());
	}
	
	@RequestMapping("/view")
	public void view(@RequestParam("id") String id, Model model) {
		log.info("view.....id : " + id);
		model.addAttribute("dto", dao.viewDao(id));
	}
	
	@RequestMapping("/writeForm")
	public void writeForm() {
		log.info("writeForm...........");
	}
	
	@RequestMapping("/write1")
	public String write1(SimpleBbsDto dto) {
		log.info("write1.....");
		dao.writeDao(dto.getWriter(), dto.getTitle(), dto.getContent());
		
		return "redirect:list";
	}
	
	@RequestMapping("/write2")
	public String write2(SimpleBbsDto dto) {
		log.info("write2.....");
		int result = dao.writeDao2(dto);
		log.info("write_result : " + result);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") String id) {
		log.info("delete.....id : " + id);
		int result = dao.deleteDao(id);
		log.info("delete_result : " + result);
		
		return "redirect:list";
	}

}
