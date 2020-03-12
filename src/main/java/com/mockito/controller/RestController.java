package com.mockito.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mockito.model.Student;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@GetMapping("/students")
	public Student getStudentName() {
		return new Student("vishal","vishal@gmail.com","8143486643");
	}
	@PostMapping("/addStudent")
	public Student createStudent(@RequestBody Student student) {
		logger.info("Json student->{}",student.toString());
		String s ="{name :vishal}";
		return student;
	}
	
//	@RequestMapping("/json")
//	public void getvalue() {
//
//	String s = "{\"a\":1,\"b\":2,\"c\":{\"d\":{\"f\":3,\"e\":4}}}";
//
//	Object val = JSONValue.parse(s);
//	JSONObject jObject = (JSONObject) val;
//	getdata(jObject);
//
//	}
//
//	public void getdata(JSONObject jObject) {
//	for (Object key : jObject.keySet()) {
//	Object value = jObject.get(key);
//
//	if(value instanceof JSONObject) {
//	//System.out.print(key+"/");
//	//Object nt=jObject.keySet();
//	//System.out.print(nt+"/");
//	getdata((JSONObject) value);
//	}else {
//	int i=Integer.parseInt(value.toString())+2;
//	System.out.println(key+" : "+i);
//	//System.out.println();
//	}
//	}
//	}

	
	

}
