package pack.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.gogek.Gogek;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankInit.xml");
		
		Gogek daniel = context.getBean("gogek", Gogek.class);
		daniel.selectBank("sinhan");
		daniel.playInputMoney(3500);
		System.out.println("daniel - sinhan");
		daniel.showMoney();
		System.out.println();
		
		Gogek john = context.getBean("gogek", Gogek.class);
		john.selectBank("sinhan");
		john.playInputMoney(3000);
		System.out.println("john - hana");
		john.showMoney();
		System.out.println();
		
		Gogek oscar = context.getBean("gogek", Gogek.class);
		oscar.selectBank("hana");
		oscar.playInputMoney(3400);
		System.out.println("oscar - hana");
		oscar.showMoney();
		
		System.out.println("객체 주소 : " + daniel);
		System.out.println("객체 주소 : " + john);
		System.out.println("객체 주소 : " + oscar);
		
		
	}

}
