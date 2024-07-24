package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDao;

@Controller
public class DeleteController {
	@Autowired
	private BoardDao boardDao;
	
	@GetMapping("delete")
	public String delete(@RequestParam("num") int num) {
		String msg = boardDao.delete(num);

		if (msg.equals("sucess")) {
			return "redirect:/list";
		} else {
			return "error";
		}
	}
}
