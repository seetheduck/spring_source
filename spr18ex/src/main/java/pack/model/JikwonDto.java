package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JikwonDto {
	private String jikwon_no, jikwon_name, jikwon_pay, buser_name, jikwon_ibsail;
}
