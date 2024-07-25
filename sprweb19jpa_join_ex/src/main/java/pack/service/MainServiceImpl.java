package pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pack.dto.JikwonDto;
import pack.entity.Gogek;
import pack.repository.GogekRepository;
import pack.repository.JikwonRepository;

@Service
public class MainServiceImpl implements MainService{
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Autowired
	private GogekRepository gogekRepository;
	
	@Override
	public void getList(Model model) {
		List<JikwonDto> list = jikwonRepository.getListAll().stream()
				.map(item -> JikwonDto.toDto(item)).toList();
		
		model.addAttribute("list", list);
	}
	
	@Override
	public void findGogek(int gogek_damsano, Model model) {
		List<Gogek> list = gogekRepository.getGogek(gogek_damsano);
		model.addAttribute("list", list);
		
	}
	
}
