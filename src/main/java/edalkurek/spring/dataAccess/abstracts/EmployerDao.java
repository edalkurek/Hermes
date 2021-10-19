package edalkurek.spring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edalkurek.spring.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer,Integer> {

}
