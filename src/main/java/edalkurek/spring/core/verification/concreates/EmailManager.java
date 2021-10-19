package edalkurek.spring.core.verification.concreates;

import edalkurek.spring.core.verification.abstracts.EmailService;
import edalkurek.spring.entities.concretes.Employer;

public class EmailManager implements EmailService  {
	
		@Override
	    public boolean verify(Employer user) {
	        //
	        return true;
	    }

	    @Override
	    public void sendMail(String email, String message) {
	        System.out.println(message+" sent to " +email);
	    }

}
