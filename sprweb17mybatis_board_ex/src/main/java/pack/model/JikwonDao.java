package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.JikwonBean;

@Repository
public class JikwonDao {
	@Autowired
	private DataMapInterface mapInterface;
	
	public List<Jikwon> list(JikwonBean bean){
		List<Jikwon> list = null;
		try {
			list = mapInterface.selectSearch(bean);
		} catch (Exception e) {
			System.out.println("list err : " + e);
		}
		return list;
	}
	
}
