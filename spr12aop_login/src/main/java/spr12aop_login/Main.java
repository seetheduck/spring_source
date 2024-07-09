package spr12aop_login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		BusinessLoginInter inter = (BusinessLoginInter)context.getBean("bImpl");
		
		inter.startProcess();
	}
	
}
