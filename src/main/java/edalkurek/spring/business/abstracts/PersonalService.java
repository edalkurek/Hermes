package edalkurek.spring.business.abstracts;

import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.entities.concretes.Personal;

import java.util.List;


public interface PersonalService {
	
	 DataResult<List<Personal>> getAll();
	    Result add(Personal personal);

}
