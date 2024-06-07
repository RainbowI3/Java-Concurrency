package org.example.auction;

import javax.net.ssl.SSLSessionBindingListener;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Auction {
    public static void main(String[] args) {

               Bidder ana1 = new Bidder("Ana", BigDecimal.valueOf(25_000_000));
               System.out.println("ana1 = "+ ana1);
                Bidder ana2 = new Bidder("Ana", BigDecimal.valueOf(25_000_000));


            //    boolean ana1IsAna2 = (ana1 == ana2);
        boolean ana1IsAna2 = ana1.equals(ana2);
                System.out.println("ana1IsAna2 = " + ana1IsAna2);

                Set<Bidder> bidders = new HashSet<>();
        bidders.add( ana1);
        bidders.add(new Bidder("Mary", BigDecimal.valueOf(20_000_000)));
        bidders.add( new Bidder("John", BigDecimal.valueOf(10_000_000)));
        bidders.add (new Bidder("Ana", BigDecimal.valueOf(15_000_000)));
                bidders.add(ana2);

        int size = bidders.size();
        System.out.println("size = " + size );
    }

}

