package edalkurek.spring.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edalkurek.spring.business.abstracts.EmployeeServices;
import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.entities.concretes.Employee;

import java.util.List;




@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	 EmployeeServices employeeServices;

	    @Autowired
	    public  EmployeeController(EmployeeServices employeeServices){
	        this.employeeServices=employeeServices;

	    }


	    @GetMapping("/getall")
	    public DataResult<List<Employee>> getAll(){
	        return this.employeeServices.getAll();
	    }

	    @PostMapping("/add")
	    public Result add(@RequestBody Employee employee){
	        return this.employeeServices.add(employee);
	    }

}
