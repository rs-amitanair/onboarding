package com.randstad.dao;

import com.randstad.model.Country;
import com.randstad.model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @param employee
     * @return
     * updated or saved employee record
     */
    public Employee addEmployee(Employee employee){
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
        return employee;
    }

    /**
     *
     * @return
     * list of all employees in the db
     */
    @Override
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }

    @Override
    public List<Country> getAllCountries(){
        return sessionFactory.getCurrentSession().createQuery("from Country").list();
    }

    /**
     *
     * @param id
     * @return
     * get employee with the passed id
     */
    @Override
    public Employee getEmployee(int id){
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public Long getMail(String mail){
         Query query=sessionFactory.getCurrentSession().createQuery("select count(id) from Employee where email= :email");
         query.setParameter("email",mail);
         Long count=(Long) query.uniqueResult();
         return count;
    }

    /**
     *
     * @param Id
     * delete employee from the db
     */
    @Override
    public void deleteEmployee(Integer Id) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, Id);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }

    }
}

