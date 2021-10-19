package edalkurek.spring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edalkurek.spring.business.abstracts.JobPositionService;
import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.ErrorResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.core.utilities.results.SuccessDataResult;
import edalkurek.spring.core.utilities.results.SuccessResult;
import edalkurek.spring.core.validation.abstracts.JobPositionValidationService;
import edalkurek.spring.core.validation.concreate.JobPositionValidationManager;
import edalkurek.spring.dataAccess.abstracts.JobPositionDao;
import edalkurek.spring.entities.concretes.JobPosition;


@Component
@Service
@SpringBootApplication
public class JobPositionManager implements JobPositionService {
	
	 private JobPositionDao jobPositionDao;
	 private JobPositionValidationService jobPositionValidationService;



	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		 this.jobPositionValidationService=new JobPositionValidationManager(jobPositionDao);
	     this.jobPositionDao = jobPositionDao;
	}



	@Override
	public DataResult<List<JobPosition>> getAll() {
		  return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Data Listed");
	}


	@Override
	public Result add(JobPosition jobPosition) {
		if(!jobPositionValidationService.isPositionUnique(jobPosition)){
            return new ErrorResult("Position already exist");
        }

        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Job Position added");

	} 

}
