package edalkurek.spring.core.validation.abstracts;

import edalkurek.spring.entities.concretes.Employer;
import edalkurek.spring.entities.concretes.Personal;

public interface EmployerValidationService {
	
	  	boolean isAllFieldFilled(Employer employer);

	    boolean isEmailUnique(String email);

	    boolean validateByPersonal(Employer employer, Personal personal);

	    boolean isValidatedByPersonal(Employer employer);

}
