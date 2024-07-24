package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// entity와 dto를 분리해야한다
// entity를 사용자에게 노출하면 원하지 않는 상황에서 자원의 속성이 변경될 가능성이 있다
// 결국 entity의 값이 달라지거나 하는 일들로부터 entity를 보호하기 위해서 분리해 사용한다

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;
	
	// FetchType.LAZY : Dept 사용 중 Emp는 필요할 때 지연 로딩.
	// 세션이 열려있는 동안 세션관리 필요하며 LazyInitializationException 조치가 필요함
	// FetchType.EAGER : 
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
	@Builder.Default	// Emp 엔티티가 생성될 때 list를 초기화함.
	private List<Emp> list = new ArrayList<Emp>();
}
