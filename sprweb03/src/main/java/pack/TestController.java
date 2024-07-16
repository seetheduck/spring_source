package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

/*
@RestController	// @Controller + @ResponseBody
public class TestController {
	
	@RequestMapping("test1")
	public String abc() {
		return "요청에 대한 반응입니당";
	}
	
}
*/

@Controller	// 사용자의 요청을 받아서 처리한 후 지정된 뷰(템플릿 엔진 : jsp...)에 모델 객체를 넘겨주는 역할
public class TestController {
	
	@RequestMapping("test1")	// get, post를 모두 처리함
	public ModelAndView abc() {
		//System.out.println("abc 처리");
		//return null;
		
		//return new ModelAndView("list", "msg", "집에 가고 싶어용");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		// request.setAttribute("msg", "집 보내줭")
		// HttpServletRequest를 사용해 키, 값으로 jsp에 전송
		modelAndView.addObject("msg", "집 보내줭");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="test2", method=RequestMethod.GET)	// get 요청 처리
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "점심시간이 곧..");
	}
	
	@GetMapping("test3")
	public ModelAndView abc3() {
		return new ModelAndView("list", "msg", "얼른 와라아아");
	}
	
	@GetMapping("test4")
	public String abc4(Model model) {
		model.addAttribute("msg", "15분 남았다..");
		return "list";
	}
	
	@RequestMapping(value="test5", method=RequestMethod.POST)
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "너무너무 졸리당");
	}
	
	@PostMapping("test6")
	public ModelAndView abc6() {
		return new ModelAndView("list", "msg", "성공6번이오");
	}
	
	@PostMapping("test7")
	public String abc7(Model model) {
		model.addAttribute("msg", "와 넘 졸리다");
		return "list";
	}
	
	@GetMapping("test8")
	@ResponseBody
	public String abc8(Model model) {
		String value = "일반 데이터-String, Map, JSON 등을 전달 가능";
		return value;
	}
	
	@GetMapping("test8_1")
	@ResponseBody
	public DataDto abc8_1() {
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("하이요");
		return dto;	// JSON 형태로 변환 (jackson 라이브러리가 지원)
	}
	
}
