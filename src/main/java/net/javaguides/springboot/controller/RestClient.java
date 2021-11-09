package net.javaguides.springboot.controller;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import net.javaguides.springboot.model.Employee;

public class RestClient {
	
	private static final String GET_ALL_EMPLOYEES_API = "http://localhost:8080/api/v1/employees";
	private static final String GET_EMPLOYEE_BY_ID_API = "http://localhost:8080/api/v1/employees/{id}";
	private static final String CREATE_EMPLOYEE_API = "http://localhost:8080/api/v1/employees";
	private static final String UPDATE_EMPLOYEE_API = "http://localhost:8080/api/v1/employees/{id}";
	private static final String DELETE_EMPLOYEE_API = "http://localhost:8080/api/v1/employees/{id}";
	
	static RestTemplate restTemplate = new RestTemplate();
	public static void main(String[] args) {
		callGetAllEmployeesAPI();
		callGetEmployeeByIdAPI();
		callCreateEmployeeAPI();
		callUpdateEmployeeAPI();
		
	}
	
	private static void callGetAllEmployeesAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_EMPLOYEES_API, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
	
	private static void callGetEmployeeByIdAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 1);
		
		Employee employee = restTemplate.getForObject(GET_EMPLOYEE_BY_ID_API, Employee.class, param);
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmail());
	}
	
	private static void callCreateEmployeeAPI() {
		Employee employee = new Employee("Buddy", "Guy", "buddyguy@email.com");
		ResponseEntity<Employee> employee2 = restTemplate.postForEntity(CREATE_EMPLOYEE_API, employee, Employee.class);
		System.out.println(employee2.getBody());
	}
	
	private static void callUpdateEmployeeAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 2);
		Employee updateEmployee = new Employee("Jessica", "Jones", "jessicajones@gmail.com");
		ResponseEntity<Employee> employee2 = restTemplate.postForEntity(UPDATE_EMPLOYEE_API, updateEmployee, Employee.class);
		System.out.println(employee2);
	}
	
	private static void callDeleteEmployeeAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 2);
		restTemplate.delete(DELETE_EMPLOYEE_API, param);
	}
}
