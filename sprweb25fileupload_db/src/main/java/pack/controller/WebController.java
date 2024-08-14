package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.Friend;
import pack.FriendService;

@Controller
public class WebController {
	
	@GetMapping("/")
	public String main() {
		return "start";
	}
	
	@Autowired
	private FriendService friendService;
	
	@GetMapping("/list")
	private String showList(Model model) {
		List<Friend> friends = friendService.findAll();
		model.addAttribute("friends", friends);
		return "list";
	}
	
}
