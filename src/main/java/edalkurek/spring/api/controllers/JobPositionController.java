package edalkurek.spring.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import edalkurek.spring.business.abstracts.JobPositionService;
import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.entities.concretes.JobPosition;



@RestController
@RequestMapping("api/jobPositions")
public class JobPositionController {
	
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll() {
		
		return this.jobPositionService.getAll();
	}
	
	 @PostMapping("/add")
	    public Result add(@RequestBody JobPosition product){

	        return this.jobPositionService.add(product);
	    }
}
