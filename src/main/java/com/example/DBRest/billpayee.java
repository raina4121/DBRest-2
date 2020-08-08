package com.example.DBRest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;

@Entity
@Table(name="billpayee", schema = "abconline")
public class billpayee {
    @Id
    private String billpayeeId;

    private String billpayeeName;

    public billpayee() {
        super();
    }

    public billpayee(String billpayeeId, String billpayeeName) {
        super();
        this.billpayeeId = billpayeeId;
        this.billpayeeName = billpayeeName;
    }

    public String getbillpayeeId() {
        return billpayeeId;
    }

    public void setbillpayeeId(String billpayeeId) {
        this.billpayeeId = billpayeeId;
    }

    public String getbillpayeeName() {
        return billpayeeName;
    }

    public void setbillpayeeName(String billpayeeName) {
        this.billpayeeName = billpayeeName;
    }
}
