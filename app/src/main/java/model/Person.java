package model;

import java.util.Date;

/**
 * Created by wilder on 26/06/15.
 */
public class Person {

    //<ambito> <tipo> <nombre>;
    private String name;
    private Double amount;
    private Date date;

    public Person(String name, Double amount, Date date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
