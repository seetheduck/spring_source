package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Member;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	private Long num;
	private String name;
	private String addr;
	
	// entity를 dto로 변환
		public static MemberDto toDto(Member entity) {
			return MemberDto.builder()
					.num(entity.getNum())
					.name(entity.getName())
					.addr(entity.getAddr())
					.build();
		}
	
}
