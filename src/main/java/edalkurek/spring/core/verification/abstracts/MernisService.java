package edalkurek.spring.core.verification.abstracts;

import edalkurek.spring.entities.concretes.Employee;

public interface MernisService {
	
	 boolean checkIfRealPerson(Employee employee);

}
