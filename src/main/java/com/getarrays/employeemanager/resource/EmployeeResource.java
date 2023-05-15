package com.getarrays.employeemanager.resource;

import com.getarrays.employeemanager.model.Employee;
import com.getarrays.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Bec this is rest service .:)
@RequestMapping("/employee")//
public class EmployeeResource {
    private final EmployeeService employeeService;
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all") //in this class one method can return all of the employees we have
    public ResponseEntity<List<Employee>> getAllEmployees (){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);//this method return list on body
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<>("Null pointer error occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //return http response generic olduğu için hangi
    // tür data olduğunu da içeride belirtrtiyorum
    //list de bir generic olduğu için hangi datayı döndüreceğini belirmem gerekli
    @GetMapping("/find/{id}") //in this class one method can return all of the employees we have
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);//this method return list on body
    }//return http response generic olduğu için hangi
    
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable ("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
