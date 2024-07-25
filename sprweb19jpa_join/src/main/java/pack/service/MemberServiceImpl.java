package pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.transaction.Transactional;
import pack.dto.MemberDto;
import pack.entity.Member;
import pack.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public void getList(Model model) {
		// 방법1 : 멤버 전체 자료를 반환 : 기본 메소드 사용
		// Member 엔티티를 MemberDto로 전달s
		/*
		List<Member> entityList = memberRepository.findAll();
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		for(Member temp:entityList) {
			MemberDto dto = new MemberDto();
			dto.setNum(temp.getNum());
			dto.setName(temp.getName());
			dto.setAddr(temp.getAddr());
			list.add(dto);
		}
		*/
		
		// 방법 2 List<Member>를 Stream으로 변경해서 map() 사용 List<MemberDto>로 변경
		List<MemberDto> list = memberRepository.findAllByOrderByNumDesc().stream()
								.map(item -> MemberDto.toDto(item)).toList();
		/*
		// 방법 3 : 람다 표현식을 메소드 참조 표현식으로 기술 클래스명 :: 매소드명
		List<MemberDto> list2 = memberRepository.findAllByOrderByNumDesc()
								.stream()
								.map(MemberDto::toDto).toList();
		*/
		
		model.addAttribute("list", list); // 컨트롤러에 MemberDto가 담긴 list 전달
	}
	
	
	@Override
	public void insert(MemberDto dto) {
		// JPA 작업 영역 내로 들어갈 때 일반 자료 전달용 객체 (Dto, FormBean)를 대응되는 엔티티로 변환
		memberRepository.save(Member.toEntity(dto));
	}
	
	// 수정 자료 읽기
	@Override
	public void getData(Long num, Model model) {
		Member m = memberRepository.findById(num).get();
		model.addAttribute("dto", MemberDto.toDto(m));
	}
	
	@Override
	public void update(MemberDto dto) {
		memberRepository.save(Member.toEntity(dto));
	}
	
	@Transactional
	@Override
	public void update2(MemberDto dto) {
		// 수정할 회원의 번호를 이용해서 회원 정보 entity 객체 얻어내기
	    Member m1 = memberRepository.findById(dto.getNum()).get();
	    Member m2 = memberRepository.findById(dto.getNum()).get();
	    
	    // 동일성 검사
	    boolean isEqual = m1 == m2;
	    System.out.println("m1과 m2가 같냐?" + isEqual);
	    
	    // setter 메소드를 이용해서 이름과 주소 수정하기
	    m1.setName(dto.getName());
	    m1.setAddr(dto.getAddr());
		
	}
	
	@Override
	public void delete(Long num) {
		memberRepository.deleteById(num);
		
	}
	
	
	
	
}
