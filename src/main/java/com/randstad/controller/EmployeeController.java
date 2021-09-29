package com.randstad.controller;

import java.io.IOException;
import java.util.List;

import com.randstad.dto.EmployeeDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.randstad.model.Employee;
import com.randstad.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

    /** getting employeeService to use it's methods */
    @Autowired
    private EmployeeService employeeService;

    /**home page mapping*/
    @RequestMapping(value = "/")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        /** getting the list of employees from the DTO and sending to the view to display */
        List<EmployeeDto> listEmployee = employeeService.getAllEmployees();
        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }

    /**new employee mapping */
    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        /**creating a new employee and displaying the employee form */
        EmployeeDto employeeDto = new EmployeeDto();
        model.addObject("employee", employeeDto);
        model.setViewName("employeeForm");
        return model;
    }

    /**save employee mapping */
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(EmployeeDto employeeDto) throws IOException {
        /** adding employee using the DTO which has been set with employee form values and redirecting to home page */
        employeeService.addEmployee(employeeDto);
        return new ModelAndView("redirect:/");
    }

    /**edit employee mapping */
    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        /** getting the employee using the id from the url and updating it */
        int employeeId = Integer.parseInt(request.getParameter("id"));
        EmployeeDto employeedto = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("employeeForm");
        model.addObject("employee", employeedto);

        return model;
    }


    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        /** deleting employee using the id */
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/");
    }


}