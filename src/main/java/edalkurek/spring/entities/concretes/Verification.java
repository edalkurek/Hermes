package edalkurek.spring.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;


@Data
@Entity
@Table(name = "verification")

public class Verification {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verification_id")
    private int verificationID;

    @Column(name = "verification_state")
    private String verificationState;

    @Column(name = "verification_type")
    private String verificationType;

    @Column(name = "verified_user")
    private int veriffiedUser;

}
