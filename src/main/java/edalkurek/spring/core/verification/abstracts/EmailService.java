package edalkurek.spring.core.verification.abstracts;

import edalkurek.spring.entities.concretes.Employer;

public interface EmailService {
	
		boolean verify(Employer user);

	    void sendMail(String email,String message);

}
