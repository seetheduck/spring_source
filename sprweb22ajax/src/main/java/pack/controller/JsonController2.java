package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController2 {
	
	@GetMapping("list2")
	@ResponseBody
	public Map<String, Object> getJsons(){	// Map<Key, Value> : 키와 값의 쌍을 저장하고 관리할 때 사용하는 데이터 구조
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "집가라");
		data.put("age", "25");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "가서 자");
		data.put("age", "28");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "휴일와라");
		data.put("age", "22");
		dataList.add(data);
		// return data;
		
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		// System.out.println("dataList : " + dataList);
		// dataList : [{name=집가라, age=25}, {name=가서 자, age=28}, {name=휴일와라, age=22}]
		// @ResponseBody에 의해 {"datas":[{"name":"집가라","age":"25"},{"name":"가서 자","age":"28"},{"name":"휴일와라","age":"22"}]} 이렇게 json 타입으로 넘어옴
		return data2;
	}
}
