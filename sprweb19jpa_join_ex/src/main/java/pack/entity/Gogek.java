package pack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Gogek {
	@Id
	@Column(name = "gogek_no")
	private int gogekno;
	private String gogek_name;
	private String gogek_tel;
	private String gogek_jumin;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "gogek_damsano", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	 private Jikwon jikwon;
	
}
