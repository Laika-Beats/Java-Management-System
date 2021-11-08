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
		param.put("id, 1");
		
		Employee employee = restTemplate.getForObject(GET_EMPLOYEE_BY_ID_API, Employee.class, param);
		
	}

}
