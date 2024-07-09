package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class GogekImpl extends JdbcDaoSupport implements GogekInter{
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void abcd() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<GogekDto> selectList(String gogekNo, String gogekName) throws DataAccessException {
		RowMapper rowMapper = new JikwonMapper();
		
		String sql = "select gogek_no, gogek_name, jikwon_name, jikwon_jik, jikwon_gen"
				+ " from gogek inner join jikwon on gogek_damsano=jikwon_no"
				+" where gogek_no=" + gogekNo + " and gogek_name=" + "'" + gogekName + "'";
		
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	class JikwonMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new GogekDto() {
				{
					setGogek_no(rs.getString("gogek_no"));
					setGogek_name(rs.getString("gogek_name"));
					setJikwon_name(rs.getString("jikwon_name"));
					setJikwon_jik(rs.getString("jikwon_jik"));
					setJikwon_gen(rs.getString("jikwon_gen"));
				}
			};
		}
	}
	
}
