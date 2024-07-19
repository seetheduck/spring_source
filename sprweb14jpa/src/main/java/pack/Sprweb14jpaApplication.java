package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pack.model.ProductCrudRepository;
import pack.model.ProductVo;

@SpringBootApplication
public class Sprweb14jpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb14jpaApplication.class, args)
				.getBean(Sprweb14jpaApplication.class).execute();
	}
	
	@Autowired
	ProductCrudRepository repository;
	
	private void execute() {
		System.out.println("execute");
		
		//insertData();
		selectData();
	}
	
	private void insertData() {
		/*
		ProductVo productVo = new ProductVo();
		productVo.setSang("볼펜");
		productVo.setSu(5);
		productVo.setDan(3000);
		productVo = repository.save(productVo);
		System.out.println("등록 데이터 : " + productVo);
		*/
		ProductVo productVo = new ProductVo();
		productVo.setCode(2);
		productVo.setSang("사인펜");
		productVo.setSu(7);
		productVo.setDan(1200);
		productVo = repository.save(productVo);
		
	}
	
	private void selectData() {
		System.out.println("전체 자료 읽기 : DBMS에 독립적이다.");
		List<ProductVo> list = repository.findAll();
		
		for(ProductVo vo:list) {
			System.out.println(vo.getCode() + " " + 
					vo.getSang() + " " + 
					vo.getSu() + " " + 
					vo.getDan());
		}
		System.out.println("부분 자료 읽기");
		ProductVo vo = repository.findById(1).get();
		System.out.println(vo.getCode() + " " + 
				vo.getSang() + " " + 
				vo.getSu() + " " + 
				vo.getDan());
		
		System.out.println();
		ProductVo vo3 = repository.findByCode(2);
		System.out.println(vo3.getCode() + " " + 
				vo3.getSang() + " " + 
				vo3.getSu() + " " + 
				vo3.getDan());
		
		System.out.println("----JPQL 사용--------");
		
		List<ProductVo> list2 = repository.findAllData();
		
		for(ProductVo vo2:list) {
			System.out.println(vo2.getCode() + " " + 
					vo2.getSang() + " " + 
					vo2.getSu() + " " + 
					vo2.getDan());
		}
		
		System.out.println("부분 자료 읽기 - JPQL");
		ProductVo vo4 = repository.findByCodeMy(3);
		System.out.println(vo4.getCode() + " " + 
				vo4.getSang() + " " + 
				vo4.getSu() + " " + 
				vo4.getDan());
		
		System.out.println();
		ProductVo vo5 = repository.findByCodeMy2(4);
		System.out.println(vo5.getCode() + " " + 
				vo5.getSang() + " " + 
				vo5.getSu() + " " + 
				vo5.getDan());
		
		System.out.println();
		List<ProductVo> list3 = repository.findByData(1, "쿠키");
		
		for(ProductVo vo6:list3) {
			System.out.println(vo6.getCode() + " " + 
					vo6.getSang() + " " + 
					vo6.getSu() + " " + 
					vo6.getDan());
		}
		
		System.out.println("\nnative SQL 결과");
		List<ProductVo> list4 = repository.findAllData2();
		for(ProductVo vo_ql:list4) {
			System.out.println(vo_ql.getCode() + " " + 
					vo_ql.getSang() + " " + 
					vo_ql.getSu() + " " + 
					vo_ql.getDan());
		}
		
		
	}
	
}
