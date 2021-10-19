package edalkurek.spring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edalkurek.spring.entities.concretes.JobPosition;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {

}
