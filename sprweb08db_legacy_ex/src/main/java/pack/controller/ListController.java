package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("testdb")
	public String listProcess(Model model, @RequestParam("param1")String param1) {
		ArrayList<JikwonDto> list = dataDao.selectJik(param1);
		model.addAttribute("jikwon_jik", param1);
		model.addAttribute("datas", list);
		
		return "list";
	}
	
}
