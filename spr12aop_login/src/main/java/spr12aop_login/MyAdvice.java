package spr12aop_login;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	@Around("execution(public void startProcess())")
	public Object abc(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("AOP 시작 : 핵심 로직 수행 전 id검사");
		
		System.out.println("input id : ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		scanner.close();
		
		if(!id.equals("ok")) {
			System.out.println("아이디 불일치네요 ㅠㅠ 작업 종료요");
			return null;
		}
		
		Object object = joinPoint.proceed();
		
		return object;
	}
	
}
