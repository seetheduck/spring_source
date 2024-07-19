package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private JikwonRepository repository;
	
	public List<Jikwon> searchlist(String sValue) {
		List<Jikwon> list = repository.findByJikContaining(sValue);
		System.out.println("list : " + list.size());
		return list;
	}
	
}
