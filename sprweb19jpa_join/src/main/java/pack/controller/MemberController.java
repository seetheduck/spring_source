package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.MemberDto;
import pack.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mservice;
	
	@GetMapping("/member/mlist")
	public String memlist(Model model) {
		mservice.getList(model);
		return "member/mlist";
	}
	
	@GetMapping("/member/insertform")
	public String insform() {
		return "member/insertform";
	}
	
	@PostMapping("/member/insert")
	public String insert(MemberDto fbean, Model model) {
		mservice.insert(fbean);
		return "member/insert";
	}
	
	@GetMapping("/member/updateform")
	public String upform(@RequestParam("num") Long num, Model model) {
		mservice.getData(num, model);
		return "member/updateform";
	}
	
	@PostMapping("/member/update")
	public String update(MemberDto fbean) {
		//mservice.update(fbean);
		mservice.update2(fbean);
		return "/member/update";
	}
	
	@GetMapping("/member/delete")
	public String delete(@RequestParam("num") Long num) {
		mservice.delete(num);
		return "redirect:/member/mlist";
	}
	
}
