package com.randstad.service;

import com.randstad.dao.EmployeeDao;
import com.randstad.dto.CountryDto;
import com.randstad.dto.EmployeeDto;
import com.randstad.model.Country;
import com.randstad.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    /**
     * adding employee to the db by converting dto to entity
     */
    public Employee addEmployee(EmployeeDto employeeDto){
        Employee employee=convertToEntity(employeeDto);
        employeeDao.addEmployee(employee);
        return employee;
    }

    @Override
    @Transactional
    /**
     * listing each employee from db,converting to dto and sending to ui
     */
    public List<EmployeeDto> getAllEmployees(){
       List<Employee> listEmployee=employeeDao.getAllEmployees();
       List<EmployeeDto> employeeDto=new ArrayList<>();
       listEmployee.forEach(
               (employee ->employeeDto.add(convertToDTO(employee)))
       );
        return employeeDto;
    }

    @Override
    @Transactional
    /**
     *
     * @param id
     * @return employee with the id passed
     */
    public EmployeeDto getEmployee(int id) {
        return convertToDTO(employeeDao.getEmployee(id));
    }

    @Transactional
    @Override
    public boolean getMail(String mail){
        if(employeeDao.getMail(mail)== 0)
            return true;
        else
            return false;
    }

    @Override
    @Transactional
    /**
     *
     * @param employeeId
     * delete employee with that id
     */
    public void deleteEmployee(Integer employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }

    @Override
    /**
     *
     * @param employee
     * @return employee dto after conversion from class
     */
    public EmployeeDto convertToDTO (Employee employee)
    {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPassword(employee.getPassword());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setCity(employee.getCity());
        employeeDto.setState(employee.getState());
        employeeDto.setCountryId(employee.getCountry().getId());
        employeeDto.setCountryName(employee.getCountry().getCountryName());
        return employeeDto;
    }

    /**
     *
     * @param employeeDto
     * @return employee class after conversion from dto
     */
    @Override
    public Employee convertToEntity(EmployeeDto employeeDto){
        Employee employee=modelMapper.map(employeeDto,Employee.class);
        return employee;
    }

    @Override
    @Transactional
    public List<CountryDto> getAllCountries() {
        List<Country> countryList=employeeDao.getAllCountries();
        List<CountryDto> countryDto=new ArrayList<>();
        countryList.forEach(
                (country->countryDto.add(convertToDTO(country)))
        );
        return countryDto;

    }

    @Override
    public CountryDto convertToDTO(Country country){
        CountryDto countryDto=modelMapper.map(country,CountryDto.class);
        return countryDto;
    }


}

