package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.BoardDao;

@Controller
public class DeleteController {
	@Autowired
	private BoardDao boardDao;
	
	@GetMapping("delete")
	public String delete(BoardBean bean) {
		boolean b = boardDao.delete(bean);
		
		if(b)
			return "redirect:/list";
		else
			return "error";
	}
	
}
