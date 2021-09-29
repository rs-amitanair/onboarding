package com.randstad.service;

import com.randstad.dto.EmployeeDto;
import com.randstad.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(EmployeeDto employeeDto);
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto getEmployee(int id);
    public void deleteEmployee(Integer employeeId);
    public EmployeeDto convertToDTO (Employee employee);
    public Employee convertToEntity(EmployeeDto employeeDto);

}
