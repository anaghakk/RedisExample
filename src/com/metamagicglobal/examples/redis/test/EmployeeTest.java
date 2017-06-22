package com.metamagicglobal.examples.redis.test;

import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.metamagicglobal.examples.redis.entity.Employee;
import com.metamagicglobal.examples.redis.entity.Employee.Gender;
import com.metamagicglobal.examples.redis.repository.EmployeeRepository;

public class EmployeeTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("resources/spring-config.xml").getPath());
		EmployeeRepository empRepo = (EmployeeRepository) context.getBean("empRepo");

		Employee emp = new Employee();
		emp.setId("101");
		emp.setAge(55);
		emp.setGender(Gender.Female);
		emp.setName("Jenny Joe");

		empRepo.addEmployee(emp);

		Employee emp2 = new Employee();
		emp2.setId("102");
		emp2.setAge(60);
		emp2.setGender(Gender.Male);
		emp2.setName("John Doe");

		empRepo.addEmployee(emp2);

		Employee emp3 = new Employee();
		emp3.setId("103");
		emp3.setAge(25);
		emp3.setGender(Gender.Male);
		emp3.setName("Ken Peg");

		empRepo.addEmployee(emp3);

		Map<Object, Object> empMap = empRepo.getAllEmployees();

		System.out.println("Display All Employees");

		System.out.println(empMap);

		System.out.println("Find Employee by ID  : " + empRepo.getEmployeeById("3"));

		System.out.println("Deleting Employee ID : 2 ");

		empRepo.delEmployeeById("2");
		
		System.out.println("Display All Employees");

		empMap = empRepo.getAllEmployees();

		System.out.println(empMap);

		context.close();

	}
}
