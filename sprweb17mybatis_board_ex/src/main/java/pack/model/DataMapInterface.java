package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.JikwonBean;

@Mapper
public interface DataMapInterface {
	List<Jikwon> selectSearch(JikwonBean bean);
	
}
