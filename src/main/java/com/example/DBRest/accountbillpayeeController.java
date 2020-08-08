package com.example.DBRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class accountbillpayeeController {
    @Autowired
    accountbillpayeeRepository accountbillpayeeRepository;

    @GetMapping("/accountbillpayees")
    public List<accountbillpayee> getAllaccountbillpayees() {
        return accountbillpayeeRepository.findAll();
    }

    @GetMapping("/accountbillpayees/{accountbillpayeeId}")
    public Optional<accountbillpayee> getAllaccountbillpayeeById(@PathVariable(value="accountbillpayeeId") String accountbillpayeeId) {
        return accountbillpayeeRepository.findById(accountbillpayeeId);
    }

    @PostMapping("/accountbillpayee")
    public @Valid accountbillpayee createaccountbillpayee(@Valid @RequestBody accountbillpayee accountbillpayee) {
        return accountbillpayeeRepository.save(accountbillpayee);
    }

    @PutMapping("/accountbillpayees/{accountbillpayeeId}")
    public @Valid accountbillpayee updateaccountbillpayee(@PathVariable(value="accountbillpayeeId") String accountbillpayeeId, @Valid @RequestBody accountbillpayee accountbillpayee)
            throws accountbillpayeeNotFoundException {
        accountbillpayee acc = accountbillpayeeRepository.findById(accountbillpayeeId).orElseThrow(()->new accountbillpayeeNotFoundException(accountbillpayeeId));
        acc.setaccountbillpayeeName(accountbillpayee.getaccountbillpayeeName());
        accountbillpayee updaccountbillpayee = accountbillpayeeRepository.save(acc);
        return updaccountbillpayee;
    }

    @DeleteMapping("accountbillpayees/{accountbillpayeeId}")
    public ResponseEntity<Void> deleteaccountbillpayee(@PathVariable("accountbillpayeeId") String accountbillpayeeId) throws accountbillpayeeNotFoundException {
        accountbillpayee acc = accountbillpayeeRepository.findById(accountbillpayeeId).orElseThrow(()->new accountbillpayeeNotFoundException(accountbillpayeeId));
        accountbillpayeeRepository.deleteById(accountbillpayeeId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}