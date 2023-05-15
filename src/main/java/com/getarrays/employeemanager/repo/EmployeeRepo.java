package com.getarrays.employeemanager.repo;

import com.getarrays.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    void deleteEmployeeById(Long id);//Spring direk t query üzerinden silmemi sağlayan metodu oluşturuyor

    Optional<Employee> findEmployeeById(Long id);//query method if i not may have employee

}
