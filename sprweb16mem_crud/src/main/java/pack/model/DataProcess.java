package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.Membean;

@Repository
public class DataProcess {
	@Autowired
	private MemRepository repository;
	
	// 전체 자료 읽기
	public List<Mem> getDataAll(){
		List<Mem> list = repository.findAll();
		return list;
	}
	
	// 해당 자료 읽기 : 수정, 삭제에서 사용
	public Mem getData(String num) {
		Mem mem = repository.findByNum(num);
		return mem;
	}
	
	// 추가
	public String insert(Membean bean){
		// 자동 증가
		// int max = repository.findByMaxNum();
		
		// num 중복 확인
		try {
			Mem mem = repository.findById(bean.getNum()).get();
			System.out.println("mem : " + mem);
			return "이미 등록된 번호 입니다";
		} catch (Exception e) {
			try {
				Mem mem = new Mem();
				mem.setNum(bean.getNum());
				mem.setName(bean.getName());
				mem.setAddr(bean.getAddr());
				mem = repository.save(mem);
				System.out.println("mem : " + mem);
				return "success";
			} catch (Exception e2) {
				return "입력 오류 : " + e2.getMessage();
			}
		}
		
	}
	
	// 수정
	public String update(Membean bean){
		try {
			Mem mem = new Mem();
			mem.setNum(bean.getNum());
			mem.setName(bean.getName());
			mem.setAddr(bean.getAddr());
			mem = repository.save(mem);
			return "success";
		} catch (Exception e) {
			return "수정 오류 : " + e.getMessage();
		}
		
	}
	
	// 삭제
	public String delete(int num){
		try {
			repository.deleteById(num);
			return "success";
		} catch (Exception e) {
			return "삭제 오류 : " + e.getMessage();
		}
		
	}
	
}
