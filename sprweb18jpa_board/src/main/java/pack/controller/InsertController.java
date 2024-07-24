package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.BoardDao;

@Controller
public class InsertController {
	@Autowired
	private BoardDao boardDao;
	
	@GetMapping("insert")
	public String insertForm() {
		return "insForm";
	}
	
	@PostMapping("insert")
	public String insertSubmit(BoardBean bean, Model model) {
		String msg = boardDao.insertData(bean);
		
		if(msg.equals("sucess")) {
			return "redirect:/list";
		}
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
	
}
