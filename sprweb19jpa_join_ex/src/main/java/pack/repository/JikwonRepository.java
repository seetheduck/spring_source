package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Jikwon;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	
	
	@Query(value = "select j from Jikwon as j order by j.jikno asc")
	public List<Jikwon> getListAll();
	
	
	
}
