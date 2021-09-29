package com.randstad.dao;

import com.randstad.dto.EmployeeDto;
import com.randstad.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Employee addEmployee(Employee employee){
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }

    @Override
    public Employee getEmployee(int id){
        return (Employee) sessionFactory.getCurrentSession().get(
                Employee.class, id);
    }

    @Override
    public void deleteEmployee(Integer Id) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, Id);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }

    }
}

