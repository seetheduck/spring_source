package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.Jikwon;

@Controller
public class JikController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("/")
	public String start() {
		return "index";
	}
	
	@GetMapping("jikwon")
	public String searchlist(FormBean bean, Model model) {
		ArrayList<Jikwon> list = (ArrayList<Jikwon>)dataDao.searchlist(bean.getSearchValue());
		model.addAttribute("datas", list);
		return "list";
	}
	
	
}
