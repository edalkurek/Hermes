package edalkurek.spring.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edalkurek.spring.business.abstracts.PersonalService;
import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.entities.concretes.Personal;

import java.util.List;


@RestController
@RequestMapping("/api/personals")
public class PersonalController {

	 private PersonalService personalService;

	    @Autowired
	    public PersonalController(PersonalService personalService){this.personalService = personalService;}

	    @GetMapping("/getall")
	    public DataResult<List<Personal>> getAll(){
	        return this.personalService.getAll();
	    }

	    @PostMapping("/add")
	    public Result add(@RequestBody Personal person){
	        return this.personalService.add(person);
	    }
}
