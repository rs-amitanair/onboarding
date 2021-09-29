package com.randstad.dao;

import com.randstad.dto.EmployeeDto;
import com.randstad.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    /** getting sessio factory */
    @Autowired
    private SessionFactory sessionFactory;

    /** saving or updating the employee that has been added */
    public Employee addEmployee(Employee employee){
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
        return employee;
    }

    /** getting the list of all employees from the table */
    @Override
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }

    /** getting the employee from the table with a particular id */
    @Override
    public Employee getEmployee(int id){
        return (Employee) sessionFactory.getCurrentSession().get(
                Employee.class, id);
    }

    /** deleting an employee with a particular id */
    @Override
    public void deleteEmployee(Integer Id) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, Id);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }

    }
}

