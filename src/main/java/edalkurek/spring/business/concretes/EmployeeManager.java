package edalkurek.spring.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edalkurek.spring.business.abstracts.EmployeeServices;
import edalkurek.spring.core.utilities.results.*;
import edalkurek.spring.core.validation.abstracts.EmployeeValidationService;
import edalkurek.spring.core.validation.concreate.EmployeeValidationManager;
import edalkurek.spring.core.verification.concreates.MernisManager;
import edalkurek.spring.dataAccess.abstracts.EmployeeDao;
import edalkurek.spring.dataAccess.abstracts.UserDao;
import edalkurek.spring.entities.concretes.Employee;

@Component
@Service
@SpringBootApplication
public class EmployeeManager<T> implements EmployeeServices {

	
	  EmployeeDao employeeDao;
	  EmployeeValidationService employeeValidationService;
	   

	    @Autowired
	    public EmployeeManager(EmployeeDao employeeDao, UserDao userDao) {
	        this.employeeDao = employeeDao;
	        //need dependency injection here
	        this.employeeValidationService = new EmployeeValidationManager(employeeDao,userDao,new MernisManager());

	    }
	
	
	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Employees Listed");
	}

	@Override
	public Result add(Employee employee) {
		List<?> xd = new ArrayList<>();
		ArrayList<Integer> xd2 = new ArrayList<>();
		
		 if(!employeeValidationService.isAllFieldFilled(employee)){
	            return new ErrorResult("You need to fill all the fields");
	        }else if(!employeeValidationService.isEmailUnique(employee.getEmail())){
	            return new ErrorResult("Email already used");
	        }else if(!employeeValidationService.isIdUnique(employee.getIdNumber())){
	            return new ErrorResult("Id number already used");
	        }else if(!employeeValidationService.isMernisVerified(employee)){
	            return new ErrorResult("Mernis verification failed");
	        }

	        this.employeeDao.save(employee);
	        return new SuccessResult("Employee saved");
	}

}
