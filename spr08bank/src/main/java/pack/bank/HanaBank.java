package pack.bank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("hana")
@Scope("prototype")
public class HanaBank implements Bank{
	private int money = 1000;
	
	@Override
	public void inputMoney(int money) {
		this.money = this.money + money;
	}
	
	@Override
	public void outputMoney(int money) {
		this.money = this.money - money;
	}
	
	@Override
	public int getMoney() {
		return money;
	}
	
}
