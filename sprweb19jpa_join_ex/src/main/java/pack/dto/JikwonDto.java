package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Jikwon;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JikwonDto {
	private int jikno;
	private String jikwon_name;
	private String jikwon_jik;
	private int buser_num;
	
	public static JikwonDto toDto(Jikwon entity) {
		return JikwonDto.builder()
				.jikno(entity.getJikno())
				.jikwon_name(entity.getJikwon_name())
				.jikwon_jik(entity.getJikwon_jik())
				.buser_num(entity.getBuser_num())
				.build();
	}
	
}
