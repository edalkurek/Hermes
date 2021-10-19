package edalkurek.spring.business.abstracts;

import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.entities.concretes.Verification;

import java.util.List;


public interface VerificationService {
	
	  DataResult<List<Verification>> getAll();
	    Result add(Verification verification);

}
