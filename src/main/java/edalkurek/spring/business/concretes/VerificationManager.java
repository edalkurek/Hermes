package edalkurek.spring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edalkurek.spring.business.abstracts.VerificationService;
import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.core.utilities.results.SuccessDataResult;
import edalkurek.spring.core.utilities.results.SuccessResult;
import edalkurek.spring.dataAccess.abstracts.VerificationDao;
import edalkurek.spring.entities.concretes.Verification;

@Component
@Service
@SpringBootApplication
public class VerificationManager implements VerificationService {
	
	 	VerificationDao verificationDao;

	    @Autowired
	    public VerificationManager(VerificationDao verificationDao){
	        this.verificationDao=verificationDao;
	    }

	@Override
	public DataResult<List<Verification>> getAll() {
		 return new SuccessDataResult<List<Verification>>(this.verificationDao.findAll(),"Verifications Listed");
	}

	@Override
	public Result add(Verification verification) {
        this.verificationDao.save(verification);
        return new SuccessResult(verification.getVerificationType()+" Verified");
	}

}
