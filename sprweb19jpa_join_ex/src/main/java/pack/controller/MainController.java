package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.service.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService mainService;
	
	
	@GetMapping("/")
	public String main(Model model) {
		mainService.getList(model);
		return "main";
	}
	
	@GetMapping("/glist/gogek")
	public String glist(@RequestParam("gogek_damsano") int gogek_damsano, Model model){
		mainService.findGogek(gogek_damsano, model);
		return "glist";
	}
	
}
