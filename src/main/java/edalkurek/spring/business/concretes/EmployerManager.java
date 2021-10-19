package edalkurek.spring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edalkurek.spring.business.abstracts.EmployerServices;
import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.ErrorResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.core.utilities.results.SuccessDataResult;
import edalkurek.spring.core.utilities.results.SuccessResult;
import edalkurek.spring.core.validation.abstracts.EmployerValidationService;
import edalkurek.spring.core.validation.concreate.EmployerValidationManager;
import edalkurek.spring.dataAccess.abstracts.EmployerDao;
import edalkurek.spring.dataAccess.abstracts.UserDao;
import edalkurek.spring.entities.concretes.Employer;

@Component
@Service
@SpringBootApplication
public class EmployerManager implements EmployerServices {
	
		EmployerValidationService employerValidationService;
	    EmployerDao employerDao;
	    @Autowired
	    public EmployerManager(EmployerDao employerDao, UserDao userDao){
	        this.employerDao=employerDao;
	        this.employerValidationService=new EmployerValidationManager(userDao,employerDao);

	    }

	@Override
	public DataResult<List<Employer>> getAll() {
		 return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employers Listed");
	}

	@Override
	public Result add(Employer employer) {
		 if(!employerValidationService.isAllFieldFilled(employer)){
	            return new ErrorResult("You need to fill all the fields");
	        }else if (employerValidationService.isEmailUnique(employer.getEmail())){
	            return new ErrorResult("Email already used");
	        }else if(employerValidationService.isValidatedByPersonal(employer)){
	            System.out.println("Need to validate");
	        }


	        this.employerDao.save(employer);
	        return new SuccessResult("Employer added");
	}

}
