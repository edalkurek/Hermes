package edalkurek.spring.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employers")

public class Employer extends User {
	
		@Column(name = "company")
	    private String company;

	    @Column(name = "website")
	    private String webSite;

	    @Column(name = "phone")
	    private  String phone;

	    @Column(name = "email_verification")
	    private boolean emailVerification;

	    @Column(name = "verified_personal")
	    private int verifiedBy;


}
