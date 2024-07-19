package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SangpumRepository extends JpaRepository<Sangpum, Integer>{
	
	// 검색
	// 메소드 네이밍룰 : findBy[엔티티명]칼럼명..., readBy[엔티티명]칼럼명..., getBy[엔티티명]칼럼명...
	// findBy변수명And변수명, findBy변수명Or변수명, findBy변수명 GreaterThanEqual... 등
	
	
	List<Sangpum> findBySangContaining(String sValue);	// sang 칼럼에 해당 검색어가 포함된 : like '%검색어%'
	List<Sangpum> findBySangStartingWith(String sValue);	// sang 칼럼에 해당 검색어로 시작되는 : like '%검색어%'
	List<Sangpum> findBySangEndingWith(String sValue);	// sang 칼럼에 해당 검색어로 끝나는 : like '%검색어%'
	
	// JPQL 사용
	@Query("select s from Sangpum as s where s.sang like %:sValue%")
	List<Sangpum> searchLike(@Param("sValue") String sValue);
	
}
