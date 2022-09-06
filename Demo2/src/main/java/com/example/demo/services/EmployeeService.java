package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee save(Employee emp)
	{
		return employeeRepository.save(emp);   // to store the data
	}
	
	public Employee getEmployee(int id)
	{
		return employeeRepository.findById(id).get();
	}
	
	public Employee update(Employee employee) 
	{
		Employee emp= employeeRepository.findById(employee.getId()).get();
		emp.setName(employee.getName());
		emp.setAge(employee.getAge());
		
		return employeeRepository.save(emp);
	}
	
	public String delete(int id)
	{
		employeeRepository.deleteById(id);
		return "Entity deleted "+id;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

}
