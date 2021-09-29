package com.randstad.service;

import com.randstad.dao.EmployeeDao;
import com.randstad.dto.EmployeeDto;
import com.randstad.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    /** converting the new employee into entity and storing into the db */
    public Employee addEmployee(EmployeeDto employeeDto){
        Employee employee=convertToEntity(employeeDto);
        employeeDao.addEmployee(employee);
        return employee;
    }

    @Override
    @Transactional
    /** getting each of the employees from the table, converting to dto and sending back to the UI */
    public List<EmployeeDto> getAllEmployees(){
       List<Employee> listEmployee=employeeDao.getAllEmployees();
       List<EmployeeDto> employeeDto=new ArrayList<>();
       listEmployee.forEach(
               (employee ->employeeDto.add(convertToDTO(employee)))
       );
        return employeeDto;
    }

    /** getting the employee based on the id, converting to dto and sending back to UI */
    public EmployeeDto getEmployee(int id) {
        return convertToDTO(employeeDao.getEmployee(id));
    }

    public void setEmployeeDAO(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
    @Transactional
    /** deleting employee using id */
    public void deleteEmployee(Integer employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }

    @Override
    /** using modelMapper to convert entity to dto so that it can interact with the UI */
    public EmployeeDto convertToDTO (Employee employee)
    {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }
    /** using modelMapper to convert dto to entity so that we can access the class */
    @Override
    public Employee convertToEntity(EmployeeDto employeeDto){
        Employee employee=modelMapper.map(employeeDto,Employee.class);
        return employee;
    }
}

