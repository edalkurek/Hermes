package edalkurek.spring.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edalkurek.spring.business.abstracts.EmployerServices;
import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.entities.concretes.Employer;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	
	
	 EmployerServices employerServices;
	    @Autowired
	    public EmployerController(EmployerServices employerServices) {
	        this.employerServices = employerServices;
	    }


	    @GetMapping("/getall")
	    public DataResult<List<Employer>> getAll(){
	        return this.employerServices.getAll();
	    }

	    @PostMapping("/add")
	    public Result add(@RequestBody Employer employer){
	        return this.employerServices.add(employer);
	    }
	/*
	    @PostMapping("/verify")
	    public Result verify(@RequestBody Employer employer){
	        Return
	    }*/

}
