package edalkurek.spring.business.abstracts;

import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.entities.concretes.Employee;
import java.util.List;

public interface EmployeeServices {
	
	 DataResult<List<Employee>> getAll();
	    Result add(Employee employee);

}
