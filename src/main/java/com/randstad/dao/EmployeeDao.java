package com.randstad.dao;

import com.randstad.model.Country;
import com.randstad.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);
    public void deleteEmployee(Integer Id);
    public List<Country> getAllCountries();
    public Long getMail(String mail);
}

