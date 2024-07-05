package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.SinhanBank;

@Service
@ComponentScan("pack.bank")
@Scope("prototype")
public class Gogek {
	private Bank bank;
	
	// false : SinhanBank가 있으면 사용하고 없으면 사용 안함, true : 없으면 err
	@Autowired(required = false)	// type으로 매핑
	private SinhanBank sinhanBank;
	
	@Resource(name = "hana")	// name으로 매핑
	private HanaBank hanaBank;
	
	public void selectBank(String sel) {
		if(sel.equals("sinhan")) {
			bank = sinhanBank;
		}else if(sel.equals("hana")) {
			bank = hanaBank;
		}
	}
	
	public void playInputMoney(int Money) {
		bank.inputMoney(Money);
	}
	
	public void playOutputMoney(int Money) {
		bank.outputMoney(Money);
	}
	
	private String msg;
	
	@PostConstruct		// 생성자 처리 후 자동 호출
	public void abc() {
		msg = "계좌 잔고 : ";
	}
	
	@PreDestroy		// 웹서비스 종료 직전 자동 호출 : 마무리 작업 가능
	public void def() {
		if(sinhanBank != null) sinhanBank = null;
		if(hanaBank != null) hanaBank = null;
	}
	
	public void showMoney() {
		System.out.println(msg + bank.getMoney());
	}
	
}
