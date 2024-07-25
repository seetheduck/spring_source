package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Gogek;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GogekDto {
	private int gogek_no;
	private String gogek_name;
	private String gogek_tel;
	private String gogek_jumin;
	private int gogek_damsano;
	
	public static GogekDto toDto(Gogek entity) {
		return GogekDto.builder()
				.gogek_no(entity.getGogekno())
				.gogek_name(entity.getGogek_name())
				.gogek_tel(entity.getGogek_tel())
				.gogek_jumin(entity.getGogek_jumin())
				.build();
	}
	
}
