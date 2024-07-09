package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	@Override
	public List<JikwonDto> selectJikwon() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;

		try {
			SqlMapperInter mapperInter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectJikwon();
		} catch (Exception e) {
			System.out.println("selectJikwon err : " + e);
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return list;

	}
	
	@Override
	public List<JikwonDto> selectBuser() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;

		try {
			SqlMapperInter mapperInter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectBuser();
		} catch (Exception e) {
			System.out.println("selectBuser err : " + e);
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return list;
	}
	
	@Override
	public List<JikwonDto> selectBuserPay() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;

		try {
			SqlMapperInter mapperInter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectBuserPay();
		} catch (Exception e) {
			System.out.println("selectBuserPay err : " + e);
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return list;
	}
	
}
