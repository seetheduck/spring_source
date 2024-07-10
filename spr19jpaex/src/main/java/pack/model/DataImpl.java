package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInter{
	
	@Override
	public List<JikwonDto> selectAllJikwon() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		List<JikwonDto> list = em.createQuery("select j from JikwonDto as j", JikwonDto.class).getResultList();
		
		em.close();
		emf.close();
		return list;
	}
	
	@Override
	public List<Object[]> selectCount() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		// 2개의 인덱스(부서번호, 직원 수)를 갖는 배열을 담은 List
		String jpql = "select j.buser_num, count(j.jikwon_no) FROM JikwonDto j group by j.buser_num";
		List<Object[]> result = em.createQuery(jpql, Object[].class).getResultList();
		
		em.close();
		emf.close();
		return result;
	}
}
