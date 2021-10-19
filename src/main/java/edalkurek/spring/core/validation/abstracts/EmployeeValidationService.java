package edalkurek.spring.core.validation.abstracts;

import edalkurek.spring.entities.concretes.Employee;

public interface EmployeeValidationService {

		boolean isAllFieldFilled(Employee employee);

	    boolean isEmailUnique(String email);

	    boolean isIdUnique(String id);

	    boolean isMernisVerified(Employee employee);
}
