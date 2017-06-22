package com.metamagicglobal.examples.redis.repository;

import java.util.Map;

import com.metamagicglobal.examples.redis.entity.Employee;

public interface EmployeeRepository 
{
		public void addEmployee(Employee person);
		
		public Employee getEmployeeById(String id);
		
		public Map<Object, Object> getAllEmployees();
		
		public void	delEmployeeById(String id);
}
