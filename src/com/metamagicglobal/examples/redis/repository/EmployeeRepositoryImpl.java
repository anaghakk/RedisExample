package com.metamagicglobal.examples.redis.repository;

import java.util.Map;

import org.springframework.data.redis.core.RedisTemplate;

import com.metamagicglobal.examples.redis.entity.Employee;
import com.metamagicglobal.examples.redis.repository.EmployeeRepository;

public class EmployeeRepositoryImpl implements  EmployeeRepository
{
		
		private RedisTemplate<String, Employee> redisTemplate;
		
		private static String EMP_KEY = "Employee";

		public RedisTemplate<String, Employee> getRedisTemplate()
		{
				return redisTemplate;
		}

		public void setRedisTemplate(RedisTemplate<String, Employee> redisTemplate)
		{
				this.redisTemplate = redisTemplate;
		}

		@Override
		public void addEmployee(Employee emp)
		{
				this.redisTemplate.opsForHash().put(EMP_KEY, emp.getId(), emp);
		}

		@Override
		public Employee getEmployeeById(String id)
		{
				return (Employee)this.redisTemplate.opsForHash().get(EMP_KEY, id);
		}

		@Override
		public Map<Object,Object> getAllEmployees()
		{
				return this.redisTemplate.opsForHash().entries(EMP_KEY);
		}

		@Override
		public void delEmployeeById(String id)
		{
				this.redisTemplate.opsForHash().delete(EMP_KEY,id);
				
		}

}
