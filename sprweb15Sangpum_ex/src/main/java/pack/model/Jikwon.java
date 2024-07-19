package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Jikwon {
	@Id
	private int jikwon_no;
	private String jikwon_name;
	private String jikwon_pay;
	private String jikwon_gen;
	@Column(name = "jikwon_jik")
	private String jik;
	
}
