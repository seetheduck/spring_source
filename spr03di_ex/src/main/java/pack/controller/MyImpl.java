package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter{
	private SangpumInter inter;
	private int su, dan;
	private String sang;
	private String[] re;
	
	public MyImpl() {
		
	}
	public MyImpl(SangpumInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void inputData() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("상품명, 수량, 단가 입력");
			sang = scanner.next();
			su = scanner.nextInt();
			dan = scanner.nextInt();
			re = inter.calcMoney(sang, su, dan);
			
		} catch (Exception e) {
			System.out.println("inputData err : " + e);
		}
		
	}
	@Override
	public void showData() {
		System.out.println("상품명 : " + re[0] + "\n" + "가격 : " + re[1] + "원");
		
	}
	
}
