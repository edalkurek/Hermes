package edalkurek.spring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edalkurek.spring.business.abstracts.PersonalService;
import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.core.utilities.results.SuccessDataResult;
import edalkurek.spring.core.utilities.results.SuccessResult;
import edalkurek.spring.dataAccess.abstracts.PersonalDao;
import edalkurek.spring.entities.concretes.Personal;

@Component
@Service
@SpringBootApplication
public class PersonalManager implements PersonalService {
	
	private PersonalDao personalDao;

    @Autowired
    public PersonalManager(PersonalDao personalDao){
        this.personalDao=personalDao;
    }

	@Override
	public DataResult<List<Personal>> getAll() {
	       return new SuccessDataResult<List<Personal>>(
	                this.personalDao.findAll(),"Personals Listed");
	}

	@Override
	public Result add(Personal personal) {
		 this.personalDao.save(personal);
	        return new SuccessResult("Personal added");
	}

}
