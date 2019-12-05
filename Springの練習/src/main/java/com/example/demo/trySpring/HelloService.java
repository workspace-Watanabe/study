package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//サービスクラスにはこのアノテーションをつける
@Service
public class HelloService {

	@Autowired
	private HelloRepository repository;

	public Employee findOne(int id) {

			//１件検索実行
		Map<String,Object>map = repository.findOne(id);

			//Mapから値を取得
		int employee_id = (Integer)map.get("employee_id");
		String employ_name = map.get("employee_name").toString();
		int age = (Integer)map.get("age");

			//Employeeクラスに値をセット
		Employee employee = new Employee();
		employee.setEmployeeId(employee_id);
		employee.setEmployeeName(employ_name);
		employee.setAge(age);

		return employee;
	}
}
