package edalkurek.spring.business.abstracts;

import java.util.List;

import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.entities.concretes.JobPosition;

public interface JobPositionService {
	
	  DataResult<List<JobPosition>>getAll();
	    Result add(JobPosition jobPosition);
}
