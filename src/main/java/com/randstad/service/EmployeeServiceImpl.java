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
    public Employee addEmployee(EmployeeDto employeeDto){
        Employee employee=convertToEntity(employeeDto);
        employeeDao.addEmployee(employee);
        return employee;
    }

    @Override
    @Transactional
    public List<EmployeeDto> getAllEmployees(){
       List<Employee> listEmployee=employeeDao.getAllEmployees();
       List<EmployeeDto> employeeDto=new ArrayList<>();
       for (Employee employee:listEmployee){
           employeeDto.add(convertToDTO(employee));
       }
       return employeeDto;
    }


    public EmployeeDto getEmployee(int id) {
        return convertToDTO(employeeDao.getEmployee(id));
    }

    public void setEmployeeDAO(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }

    @Override
    public EmployeeDto convertToDTO (Employee employee)
    {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }
    @Override
    public Employee convertToEntity(EmployeeDto employeeDto){
        Employee employee=modelMapper.map(employeeDto,Employee.class);
        return employee;
    }
}
