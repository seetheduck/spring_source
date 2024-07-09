package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{
	
	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();	// 엔티티의 생명주기를 관리. CRUD를 수행
		EntityTransaction tx = em.getTransaction();		// Transaction을 관리하는 인터페이스
		
		System.out.println("전체 자료 읽기 ------");
		List<MemDto> list = null;
		list = findAll(em, MemDto.class);
		for(MemDto m:list) {
			System.out.println(m.getNumber() + " " + m.getName() + " " + m.getAddr());
		}
		
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla){
		// JPQL
		// cla.getName() : pack
		return em.createQuery("select e from " + cla.getName() + " e", cla).getResultList();
	}
	
}
