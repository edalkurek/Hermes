package edalkurek.spring.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import edalkurek.spring.entities.abstracts.Entities;

import lombok.Data;


@Data
@Entity
@Table(name ="jobpositions")

public class JobPosition implements Entities   {
	

	 	@Id
	    @GeneratedValue
	    @Column(name = "job_id")
	    private int id;


	    @Column(name = "job_name")
	    private String jobName;
	
	

	
	}


