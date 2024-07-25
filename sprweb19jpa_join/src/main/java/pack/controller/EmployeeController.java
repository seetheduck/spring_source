package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import pack.dto.DeptDto;
import pack.dto.EmpDto;
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;


@Controller
public class EmployeeController {
	@Autowired
	private EntityManagerFactory factory;
	
	@Autowired
	private EmpRepository empRepo;
	
	@Autowired
	private DeptRepository deptRepo;
	
	@GetMapping("/employee/list")
	public String emplist(Model model) {
		// 모든 직원 정보 출력
		//List<Emp> list = empRepo.findAll();	// 기본 메소드
		//List<Emp> list = empRepo.findAllByOrderByEmpnoAsc();
		//List<Emp> list = empRepo.findAllByOrderByEmpnoDesc();
		List<Emp> list = empRepo.getListAll();
		//List<Emp> list = empRepo.getList(1500);
		
		model.addAttribute("list", list);
		return "employee/elist";
	}
	
	@GetMapping("/employee/dept")	// 부서정보 출력
	public String emplist(@RequestParam("deptno") int deptno, Model model) {
		Dept d = deptRepo.findById(deptno).get();
		DeptDto dto = DeptDto.toDto(d);
		model.addAttribute("dto", dto);
		
		return "employee/dept";
	}
	
	// JPQL 연습장 관련
	@GetMapping("/jpql")
	public String jpql() {
		return "jpql";
	}
	
	@ResponseBody
	@PostMapping("/jpql/test")
	public List<EmpDto> test(@RequestParam("query") String query) {
		//System.out.println(query);	// select e from Emp as e
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<EmpDto> list = null;
		
		try {
			// 전달받은 query(JPQL)문을 실행
			TypedQuery<Emp> tQuery = em.createQuery(query, Emp.class);
			
			list = tQuery.getResultStream().map(EmpDto::toDto).toList();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
		return list;
	}
	
	
}
