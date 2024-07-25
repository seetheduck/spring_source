package pack.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{
	// 사원 번호에 대해 오름차순 정렬된 목록 반환 메소드
	public List<Emp> findAllByOrderByEmpnoAsc();
	public List<Emp> findAllByOrderByEmpnoDesc();
	
	// findAllByOrderByEmpnoAsc() 메소드를 JPQL로 적는다면 아래와 같다
	@Query(value = "select e from Emp e order by e.empno asc")
	public List<Emp> getListAll();
	
	// 인자 전달
	// 입력 salary 초과 자료 오름차순 정렬
	@Query("select e from Emp e where e.sal > :salary order by e.sal asc")
	List<Emp> getList(@Param("salary") double salary);
	
	@Query("select e from Emp e where e.sal > :sal1 and e.sal < :sal2 order by e.sal asc")
	List<Emp> getListBetween(@Param("sal1") int sal1, @Param("sal2") int sal2);
	
	@Query("select e from Emp e where e.sal > ?1 and e.sal < ?2 order by e.sal asc")
	List<Emp> getListBetween2(int sal1, int sal2);
	
	
}
