package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport {
	@Autowired
	public DataDao(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public List<JikwonDto> selectJik(String jik) {
		String sql = "select * from jikwon where jikwon_jik=?";
		Object[] param = {jik};
		
		List<JikwonDto> list = getJdbcTemplate().query(sql, param, new RowMapper<JikwonDto>() {
			@Override
			public JikwonDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				JikwonDto dto = new JikwonDto();
				dto.setJikwon_no(rs.getString("jikwon_no"));
				dto.setJikwon_name(rs.getString("jikwon_name"));
				dto.setJikwon_gen(rs.getString("jikwon_gen"));
				dto.setJikwon_pay(rs.getString("jikwon_pay"));
				return dto;
			}
		});
		
		return list;
	}
	
	/*
	@Repository
	public class DataDao {
		private JdbcTemplate jdbcTemplate;

		@Autowired
		public DataDao(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}

		public ArrayList<JikwonDto> selectJik(String jik) {
			String sql = "select * from jikwon where jikwon_jik=?";
			
			List<JikwonDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(JikwonDto.class), jik);
			
			return new ArrayList<>(list);
		}
	*/
}

