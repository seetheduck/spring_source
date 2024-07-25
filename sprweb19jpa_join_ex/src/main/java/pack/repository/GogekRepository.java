package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Gogek;

public interface GogekRepository extends JpaRepository<Gogek, Integer>{
	public List<Gogek> findAllByOrderByGogeknoAsc();
	
	@Query("select g from Gogek as g where gogek_damsano = ?1")
	public List<Gogek> getGogek(int gogek_damsano);
	
}
