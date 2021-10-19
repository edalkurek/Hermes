package edalkurek.spring.core.validation.concreate;

import org.springframework.beans.factory.annotation.Autowired;

import edalkurek.spring.core.validation.abstracts.EmployeeValidationService;
import edalkurek.spring.core.verification.abstracts.MernisService;
import edalkurek.spring.dataAccess.abstracts.EmployeeDao;
import edalkurek.spring.dataAccess.abstracts.UserDao;
import edalkurek.spring.entities.concretes.Employee;
import edalkurek.spring.entities.concretes.User;

import java.util.List;

public class EmployeeValidationManager implements EmployeeValidationService {

		EmployeeDao employeeDao;
	    UserDao userDao;
	    MernisService mernisService;
	    @Autowired
	    public EmployeeValidationManager(EmployeeDao employeeDao, UserDao userDao, MernisService mernisService) {
	        this.employeeDao = employeeDao;
	        this.userDao = userDao;
	        this.mernisService = mernisService;
	    }


	    @Override
	    public boolean isAllFieldFilled(Employee employee) {
	        return employee.getIdNumber()!= null && employee.getFirstName()!=null && employee.getLastName()!=null&&
	                employee.getPassword()!=null;


	    }

	    @Override
	    public boolean isEmailUnique(String email) {
	        List<User> allUsers= userDao.findAll();
	        for (User e: allUsers) {
	            if(e.getEmail().equals(email)){
	                return false;
	            }
	        }
	        return true;
	    }

	    @Override
	    public boolean isIdUnique(String id) {
	        List<Employee> allUsers= employeeDao.findAll();
	        for (Employee e: allUsers) {
	            if(e.getIdNumber().equals(id)){
	                return false;
	            }
	        }
	        return true;
	    }

	    @Override
	    public boolean isMernisVerified(Employee employee) {
	        return mernisService.checkIfRealPerson(employee);
	    }

}
