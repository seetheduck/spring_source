package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.BoardDao;

@Controller
public class UpdateController {
	@Autowired
	private BoardDao boardDao;
	
	@PostMapping("update")
	public String update(BoardBean bean, Model model) {
		boolean b = boardDao.update(bean);
		
		if(b)
			return "redirect:/list";
		else
			return "error";
	}
	
	
}
