package anno2_resource;

import org.springframework.stereotype.Component;

@Component("aaa")
public class Abc2 {		// POJO(Plain Old Java Object) : 순수하게 멤버와 메소드로만 이루어진 클래스(getter, setter만 존재)
	private int nai;

	public int getNai() {
		return nai;
	}

	public void setNai(int nai) {
		this.nai = nai;
	}
	
}
