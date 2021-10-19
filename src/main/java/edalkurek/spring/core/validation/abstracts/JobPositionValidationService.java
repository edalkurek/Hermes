package edalkurek.spring.core.validation.abstracts;

import edalkurek.spring.entities.concretes.JobPosition;

public interface JobPositionValidationService {

	  boolean isPositionUnique(JobPosition jobPosition);
}
