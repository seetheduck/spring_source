package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter{
	// model 클래스를 호출
	@Autowired
	private JikwonInter inter;
	
	@Override
	public void dataPrint() {
		List<JikwonDto> list = inter.selectJikwon();
		
		System.out.println("직원 자료\n사번 이름 부서명 입사년");
		
		// console로 출력
		for(JikwonDto s:list) {
			System.out.println(s.getJikwon_no() + " " + s.getJikwon_name() + " " + s.getBuser_name() + " " + s.getJikwon_ibsail());
		}
		
		list = inter.selectBuser();
		
		System.out.println("\n부서별 인원수");
		for(JikwonDto s:list) {
			System.out.println(s.getBuser_name() + " " + s.getJikwon_no());
		}
		
		list = inter.selectBuserPay();
		
		System.out.println("\n부서별 최대 급여자");
		for(JikwonDto s:list) {
			System.out.println(s.getBuser_name() + " " + s.getJikwon_name() + " " + s.getJikwon_pay());
		}
		
	}
	
}
