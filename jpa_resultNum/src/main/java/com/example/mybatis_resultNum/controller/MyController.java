package com.example.mybatis_resultNum.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mybatis_resultNum.entity.SimpleBbs;
import com.example.mybatis_resultNum.repository.SimpleBbsRepository;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MyController {
	
	@Autowired
	SimpleBbsRepository simpleBbsRepository;
	
	@RequestMapping("/")
	public String root() {
		log.info("root..........");
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("list..........");
		model.addAttribute("total", simpleBbsRepository.count());
		model.addAttribute("list", simpleBbsRepository.findAll());
		
		return "list";
	}
	
	@RequestMapping("/view")
	public void view(@RequestParam("id") Long id, Model model) {
		log.info("view.....id : " + id);
		SimpleBbs simpleBbs = null;
		
		Optional<SimpleBbs> result = simpleBbsRepository.findById(id);
		
		if(result.isPresent()) {
			simpleBbs = result.get();
		}
		model.addAttribute("dto", simpleBbs);
	}
	
	@RequestMapping("/writeForm")
	public void writeForm() {
		log.info("writeForm...........");
	}

	@RequestMapping("/write1")
	public String write1(SimpleBbs dto) {
		log.info("write1.....");
		simpleBbsRepository.save(dto);
		
		return "redirect:list";
	}
	
	@RequestMapping("/write2")
	public String write2(SimpleBbs dto) {
		log.info("write2.....");
		simpleBbsRepository.save(dto);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		log.info("delete.....id : " + id);
		simpleBbsRepository.deleteById(id);
		
		return "redirect:list";
	}
}
