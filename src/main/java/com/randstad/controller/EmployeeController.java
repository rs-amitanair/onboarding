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

    @Autowired
    private EmployeeService employeeService;
    EmployeeDto employeeDto;

    @RequestMapping(value = "/")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<EmployeeDto> listEmployee = employeeService.getAllEmployees();
        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        EmployeeDto employee = new EmployeeDto();
        model.addObject("employee", employee);
        model.setViewName("employeeForm");
        return model;
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(EmployeeDto employeeDto) throws IOException {
        employeeService.addEmployee(employeeDto);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        EmployeeDto employeedto = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("employeeForm");
        model.addObject("employee", employeedto);

        return model;
    }


    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/");
    }


}