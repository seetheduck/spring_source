package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemRepository extends JpaRepository<Mem, Integer>{
	
	// num 자동 증가용
	//@Query("select max(num) from mem" nativeQuery = true)
	@Query("select max(m.num) from Mem as m")
	int findByMaxNum();
	
	
}
