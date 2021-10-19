package edalkurek.spring.business.abstracts;

import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.entities.concretes.Employer;

import java.util.List;


public interface EmployerServices {
	
    DataResult<List<Employer>> getAll();
    Result add(Employer employer);

}
