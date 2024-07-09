package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select("select jikwon_no, jikwon_name, substr(jikwon_ibsail,1,4) as jikwon_ibsail, "
			+ "case buser_name when null then '무소속' else buser_name end as buser_name "
			+ "from jikwon inner join buser on jikwon.buser_num = buser.buser_no")
	public List<JikwonDto> selectJikwon();
	@Select("select buser_name, count(jikwon_no) as jikwon_no from buser inner join jikwon on buser_no=buser_num group by buser_num")
	public List<JikwonDto> selectBuser();
	@Select("select buser_name, jikwon_name, jikwon_pay from buser inner join jikwon on buser_no="
			+ "buser_num where jikwon_pay in(select max(jikwon_pay) from jikwon j where j.buser_num=jikwon.buser_num)")
	public List<JikwonDto> selectBuserPay();
}
