package com.yjj.MVCBoard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjj.MVCBoard.command.BCoammand;
import com.yjj.MVCBoard.command.BContentCommand;
import com.yjj.MVCBoard.command.BDeleteCommand;
import com.yjj.MVCBoard.command.BListCommand;
import com.yjj.MVCBoard.command.BModifycommand;
import com.yjj.MVCBoard.command.BReplyCommand;
import com.yjj.MVCBoard.command.BReplyViewCommand;
import com.yjj.MVCBoard.command.BWriteCommand;
import com.yjj.MVCBoard.util.Constant;

@Controller
public class BController {

	
	BCoammand command = null;
	
	
	private JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	
	
	

	@RequestMapping("/")
	public String root(Model model) {
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		command = new BListCommand();
		command.excute(model);
		
		return "list";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		
		model.addAttribute("request", request);
		
		command = new BWriteCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/write_form")
	public String write_form() {
		
		return "write_form";
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentCommand();
		command.excute(model);
		
		return "content_view";
	}
	
	
	
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentCommand();
		command.excute(model);
		
		
		return "modify_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BModifycommand();
		command.excute(model);
		
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BDeleteCommand();
		command.excute(model);
		
		
		return "redirect:list";
	}
	
	
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BReplyViewCommand();
		command.excute(model);
		
		
		return "reply_view";
	}
	
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BReplyCommand();
		command.excute(model);
		
		
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
