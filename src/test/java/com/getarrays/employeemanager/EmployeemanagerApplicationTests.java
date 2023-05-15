package com.getarrays.employeemanager;

import com.getarrays.employeemanager.model.Employee;
import com.getarrays.employeemanager.resource.EmployeeResource;
import com.getarrays.employeemanager.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeemanagerApplicationTests {

	@Autowired
	private EmployeeResource employeeResource;

	@MockBean
	private EmployeeService employeeService;

	@Test
	public void getAllEmployeesTest() {
		List<Employee> employees = new ArrayList<>();
		Employee employee1 = new Employee("John", "Doe", "john.doe@example.com");
		Employee employee2 = new Employee("Jane", "Doe", "jane.doe@example.com");
		employees.add(employee1);
		employees.add(employee2);

		Mockito.when(employeeService.findAllEmployees()).thenReturn(employees);

		ResponseEntity<List<Employee>> response = employeeResource.getAllEmployees();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, response.getBody().size());
		assertEquals(employee1.getName(), response.getBody().get(0).getName());
	}

	@Test
	public void getEmployeeByIdTest() {
		Long id = 1L;
		Employee employee = new Employee("John", "Doe", "john.doe@example.com");
		employee.setId(id);

		Mockito.when(employeeService.findEmployeeById(id)).thenReturn(employee);

		ResponseEntity<Employee> response = employeeResource.getEmployeeById(id);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(employee.getName(), response.getBody().getName());
		assertEquals(employee.getEmail(), response.getBody().getEmail());
	}

	@Test
	public void addEmployeeTest() {
		Employee employee = new Employee("John", "Doe", "john.doe@example.com");

		Mockito.when(employeeService.addEmployee(employee)).thenReturn(employee);

		ResponseEntity<Employee> response = employeeResource.addEmployee(employee);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(employee.getName(), response.getBody().getName());
		assertEquals(employee.getEmail(), response.getBody().getEmail());
	}

	@Test
	public void deleteEmployeeTest() {
		Long id = 1L;
		ResponseEntity<?> response = employeeResource.deleteEmployee(id);
		Mockito.verify(employeeService, Mockito.times(1)).deleteEmployee(id);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}

