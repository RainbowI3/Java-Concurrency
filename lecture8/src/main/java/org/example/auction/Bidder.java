package org.example.auction;

import java.math.BigDecimal;
import java.util.Objects;

//@Data
public class Bidder extends Object {

    public Bidder(String name,BigDecimal balance){
        if(balance == null || balance.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("invalid balance, should be a positive number");
        }
        this.name = name;
        this.balance = balance;


    }
    private String name;
    private BigDecimal balance;
    private boolean  suspended;

    @Override
    public String toString(){
        return" Bidder " + name + " with balance "+ balance + " is "+
                (suspended? "not active" : "active");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bidder bidder = (Bidder) o;
        return Objects.equals(name, bidder.name);
    }
//    @Override
//    public boolean equals(Object obj) {
//        if(obj == null)return false;
//        if(!(obj instanceof Bidder ))return false;
//        Bidder other = (Bidder)obj;
//        return this.name.equals(other.name);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
