package edalkurek.spring.core.validation.concreate;

import org.springframework.beans.factory.annotation.Autowired;

import edalkurek.spring.core.validation.abstracts.JobPositionValidationService;
import edalkurek.spring.dataAccess.abstracts.JobPositionDao;
import edalkurek.spring.entities.concretes.JobPosition;

import java.util.List;

public class JobPositionValidationManager implements JobPositionValidationService {

	 JobPositionDao jobPositionDao;
	    @Autowired
	    public JobPositionValidationManager(JobPositionDao jobPositionDao) {
	        this.jobPositionDao = jobPositionDao;
	    }

	    @Override
	    public boolean isPositionUnique(JobPosition jobPosition) {
	        List<JobPosition> allPosition=jobPositionDao.findAll();

	        for (JobPosition j: allPosition
	             ) {
	            if(j.getJobName().equals(jobPosition.getJobName())){
	                return false;
	            }

	        }return true;




	    }
}
