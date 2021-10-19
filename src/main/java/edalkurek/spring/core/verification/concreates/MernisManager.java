package edalkurek.spring.core.verification.concreates;

import edalkurek.spring.core.verification.abstracts.MernisService;
import edalkurek.spring.entities.concretes.Employee;

public class MernisManager implements MernisService {
	
	@Override
    public boolean checkIfRealPerson(Employee employee) {
        return employee.getIdNumber().length() == 11;
    }

}
