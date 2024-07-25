package pack.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.dto.JikwonDto;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Jikwon {
	@Id
	@Column(name = "jikwon_no")
	private Integer jikno;
	private String jikwon_name;
	private String jikwon_jik;
	private int buser_num;
	
	
	@OneToMany(mappedBy = "jikwon", fetch = FetchType.EAGER)
    private List<Gogek> list;
	
	public static Jikwon toEntity(JikwonDto dto) {
		return Jikwon.builder()
				.jikno(dto.getJikno())
				.jikwon_name(dto.getJikwon_name())
				.jikwon_jik(dto.getJikwon_jik())
				.buser_num(dto.getBuser_num())
				.build();
	}
	
}
