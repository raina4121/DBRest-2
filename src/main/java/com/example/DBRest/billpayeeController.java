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
public class billpayeeController {
    @Autowired
    billpayeeRepository billpayeeRepository;

    @GetMapping("/billpayee")
    public List<billpayee> getAllbillpayees() {
        return billpayeeRepository.findAll();
    }

    @GetMapping("/billpayee/{billpayeeId}")
    public Optional<billpayee> getAllbillpayeeById(@PathVariable(value = "billpayeeId") String billpayeeId) {
        return billpayeeRepository.findById(billpayeeId);
    }

    @PostMapping("/billpayee")
    public @Valid billpayee createbillpayee(@Valid @RequestBody billpayee billpayee) {
        return billpayeeRepository.save(billpayee);
    }

    @PutMapping("/billpayees/{billpayeeId}")
    public @Valid billpayee updatebillpayee(@PathVariable(value = "billpayeeId") String billpayeeId, @Valid @RequestBody billpayee billpayee)
            throws billpayeeNotFoundException {
        billpayee acc = billpayeeRepository.findById(billpayeeId).orElseThrow(() -> new billpayeeNotFoundException(billpayeeId));
        acc.setbillpayeeName(billpayee.getbillpayeeName());
        billpayee updbillpayee = billpayeeRepository.save(acc);
        return updbillpayee;
    }

    @DeleteMapping("billpayees/{billpayeeId}")
    public ResponseEntity<Void> deletebillpayee(@PathVariable("billpayeeId") String billpayeeId) throws billpayeeNotFoundException {
        billpayee acc = billpayeeRepository.findById(billpayeeId).orElseThrow(() -> new billpayeeNotFoundException(billpayeeId));
        billpayeeRepository.deleteById(billpayeeId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}