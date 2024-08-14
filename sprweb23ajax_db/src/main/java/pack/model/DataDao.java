package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.SangpumDto;

@Repository
public class DataDao {
	@Autowired
	private DataRepository dataRepository;
	
	public List<SangpumDto> getSangpumAll(){
		List<SangpumDto> slist = dataRepository.findAll().stream()
			.map(Sangpum -> SangpumDto.builder()
					.code(Sangpum.getCode())
					.sang(Sangpum.getSang())
					.su(Sangpum.getSu())
					.dan(Sangpum.getDan())
					.build())
			.collect(Collectors.toList());
		
		return slist;
	}
	
	
}
