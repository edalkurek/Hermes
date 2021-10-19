package edalkurek.spring.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edalkurek.spring.business.abstracts.VerificationService;
import edalkurek.spring.core.utilities.results.DataResult;
import edalkurek.spring.core.utilities.results.Result;
import edalkurek.spring.entities.concretes.Verification;

import java.util.List;


@RestController
@RequestMapping("/api/verifications")
public class VerificationController {

	VerificationService verificationService;


    @Autowired
    public  VerificationController(VerificationService verificationService){
        this.verificationService=verificationService;

    }


    @GetMapping("/getall")
    public DataResult<List<Verification>> getAll(){
        return this.verificationService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Verification verification){
        return this.verificationService.add(verification);
    }

}
