package edalkurek.spring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edalkurek.spring.entities.concretes.Personal;

@Repository
public interface PersonalDao extends JpaRepository<Personal,Integer> {

}
