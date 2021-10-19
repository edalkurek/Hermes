package edalkurek.spring.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employee")



	public class Employee extends User {
	
		@Column(name = "first_name")
	    private String firstName;

	    @Column(name = "last_name")
	    private String lastName;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_number")
	    private String idNumber;

	    @Column(name = "birthdate")
	    private String date;

	    @Column(name = "mernis",nullable = true)
	    private Boolean mernis;


}
