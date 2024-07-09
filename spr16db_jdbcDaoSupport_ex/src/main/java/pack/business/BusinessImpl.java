package pack.business;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.GogekDto;
import pack.model.GogekInter;

@Service
public class BusinessImpl implements BusinessInter{
	// model을 포함관계로 호출
	@Autowired
	private GogekInter gogekInter;
	
	@Override
	public void jikwonList() {
		System.out.println("로그인 정보 입력");
		Scanner scanner = new Scanner(System.in);
		System.out.println("고객 번호 : ");
		String gogekNo = scanner.next();
		System.out.println("고객 이름 : ");
		String gogekName = scanner.next();
		scanner.close();
		
		List<GogekDto> list = gogekInter.selectList(gogekNo, gogekName);
		
		if(list.isEmpty()) {
			System.out.println("로그인 정보가 맞지 않아요");
		}
		else {
			for(GogekDto j:list) {
					System.out.println("담당 직원 정보\n" + 
							j.getJikwon_name() + " " + 
							j.getJikwon_jik() + " " + 
							j.getJikwon_gen());
			}
		}
		
	}
	
	
}
