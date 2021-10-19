package edalkurek.spring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edalkurek.spring.entities.concretes.Verification;

@Repository
public interface VerificationDao extends JpaRepository<Verification,Integer> {

}
