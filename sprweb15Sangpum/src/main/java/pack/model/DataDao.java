package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.FormBean;

@Repository
public class DataDao {
	@Autowired
	private SangpumRepository repository;
	
	// 전체 자료 읽기
	public List<Sangpum> getDataAll(){
		List<Sangpum> list = repository.findAll();	// 기본 메소드
		return list;
	}
	
	// 검색 자료 읽기
	public List<Sangpum> getDataSearch(String sValue) {
		List<Sangpum> list = repository.findBySangContaining(sValue);
		//List<Sangpum> list = repository.searchLike(sValue);
		
		System.out.println("list : " + list.size());
		return list;
	}
	
}
