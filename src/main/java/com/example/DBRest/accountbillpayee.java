package com.example.DBRest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accountbillpayee", schema = "abconline")
public class accountbillpayee {
    @Id
    private String accountbillpayeeID;

    private String accountbillpayeeName;

    public accountbillpayee() {
        super();
    }

    public accountbillpayee(String accountbillpayeeId, String accountbillpayeeName) {
        super();
        this.accountbillpayeeID = accountbillpayeeID;
        this.accountbillpayeeName = accountbillpayeeName;
    }

    public String getaccountbillpayeeId() {
        return accountbillpayeeID;
    }

    public void setaccountbillpayeeId(String accountbillpayeeId) {
        this.accountbillpayeeID = accountbillpayeeId;
    }

    public String getaccountbillpayeeName() {
        return accountbillpayeeName;
    }

    public void setaccountbillpayeeName(String accountbillpayeeName) {
        this.accountbillpayeeName = accountbillpayeeName;
    }
}
