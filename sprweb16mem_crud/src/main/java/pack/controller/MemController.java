package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.Mem;

@Controller
public class MemController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/")
	public String main() {
		return "chulbal";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<Mem> list = (ArrayList<Mem>) dataProcess.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertProcess(Membean bean, Model model) {
		String msg = dataProcess.insert(bean);
		
		if(msg.equals("success"))
			return "redirect:/list";
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
	// 수정
	@GetMapping("update")
	public String update(@RequestParam("num") String num, Model model) {
		Mem mem = dataProcess.getData(num);
		model.addAttribute("data", mem);
		return "update";
	}
	
	// 수정
	@PostMapping("update")
	public String updateProcess(Membean bean, Model model) {
		String msg = dataProcess.update(bean);
		
		if(msg.equals("success"))
			return "redirect:/list";
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
	// 삭제
	@GetMapping("delete")
	public String delete(@RequestParam("num") int num, Model model) {
		String msg = dataProcess.delete(num);
		if(msg.equals("success"))
			return "redirect:/list";
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
}
