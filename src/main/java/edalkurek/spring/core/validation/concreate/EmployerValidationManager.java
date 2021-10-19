package edalkurek.spring.core.validation.concreate;

import org.springframework.beans.factory.annotation.Autowired;

import edalkurek.spring.core.validation.abstracts.EmployerValidationService;
import edalkurek.spring.dataAccess.abstracts.EmployerDao;
import edalkurek.spring.dataAccess.abstracts.UserDao;
import edalkurek.spring.entities.concretes.Employer;
import edalkurek.spring.entities.concretes.Personal;
import edalkurek.spring.entities.concretes.User;

import java.util.List;

public class EmployerValidationManager implements EmployerValidationService {

	UserDao userDao;
    EmployerDao employerDao;



    @Autowired
    public EmployerValidationManager(UserDao userDao, EmployerDao employerDao) {
        this.userDao = userDao;
        this.employerDao = employerDao;
    }

    @Override
    public boolean isAllFieldFilled(Employer employer) {
        return employer.getEmail()!= null && employer.getCompany()!=null && employer.getPassword()!=null&&
                employer.getWebSite()!=null;
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
    public boolean validateByPersonal(Employer employer, Personal personal) {
        return false;
    }

    @Override
    public boolean isValidatedByPersonal(Employer employer) {
        return employer.getVerifiedBy()>0;
    }
}
