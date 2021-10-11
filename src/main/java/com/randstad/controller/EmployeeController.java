package com.randstad.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.randstad.dto.CountryDto;
import com.randstad.dto.EmployeeDto;

import com.randstad.model.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.randstad.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     *
     * @param model
     * @return
     * list of all employees in the db
     * @throws IOException
     */
    @RequestMapping(value = "/")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<EmployeeDto> listEmployee = employeeService.getAllEmployees();
        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }

    /**
     *
     * @param model
     * @return
     * employee form
     */
    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        EmployeeDto employeeDto = new EmployeeDto();
        //Employee emp=new Employee();
        //emp.getCountry().getCountryName();
        List<CountryDto> countryList=employeeService.getAllCountries();
        model.addObject("countryList",countryList);
        model.addObject("employee", employeeDto);
        model.setViewName("employeeForm");
        return model;
    }

    /**
     *
     * @param employeeDto
     * @return
     * redirect to home page after saving employee in db
     * @throws IOException
     */
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(EmployeeDto employeeDto) throws IOException {
        employeeService.addEmployee(employeeDto);
        return new ModelAndView("redirect:/");
    }

    /**
     *
     * @param request
     * @return
     * edited employee data
     */
    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        List<CountryDto> countryList=employeeService.getAllCountries();
        EmployeeDto employeedto = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("editForm");
        model.addObject("countryList",countryList);
        model.addObject("employee", employeedto);

        return model;
    }

    /**
     *
     * @param request
     * @return
     * delete employee and redirect to home page
     */
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/validateMail",method = RequestMethod.GET)
    @ResponseBody
    public boolean emailValidation(HttpServletRequest request){
        String mail=request.getParameter("email");
         return employeeService.getMail(mail);
    }

    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        ModelAndView errorPage = new ModelAndView("errorPage");
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            }
            default: errorMsg="An unexpected error has occurred";
        }
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}