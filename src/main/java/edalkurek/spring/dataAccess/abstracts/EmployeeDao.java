package edalkurek.spring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edalkurek.spring.entities.concretes.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>{

}
