package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.Jikwon;
import pack.model.JikwonDao;

@Controller
public class ListController {
	@Autowired
	private JikwonDao jikwonDao;
	
	@GetMapping("list")
	public String list(JikwonBean bean, Model model) {
		ArrayList<Jikwon> list = (ArrayList<Jikwon>) jikwonDao.list(bean);
		model.addAttribute("list", list);
		
		// 연봉 평균 구하기
			double avgPay = 0;
			for(Jikwon j : list) {
				avgPay += j.getJikwon_pay();
			}
			avgPay = Math.round((avgPay / list.size())*100) / 100.0; // 소수점 이하 세번째에서 반올림
			model.addAttribute("avg", avgPay);

		return "list";
	}
	
}
