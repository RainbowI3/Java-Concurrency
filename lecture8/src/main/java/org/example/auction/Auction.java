package org.example.auction;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Slf4j
public class Auction {
    public static void main(String[] args) {

//               Bidder ana1 = new Bidder("Ana", BigDecimal.valueOf(25_000_000));
//               System.out.println("ana1 = "+ ana1);
//                Bidder ana2 = new Bidder("Ana", BigDecimal.valueOf(25_000_000));
//
//
//            //    boolean ana1IsAna2 = (ana1 == ana2);
//        boolean ana1IsAna2 = ana1.equals(ana2);
//                System.out.println("ana1IsAna2 = " + ana1IsAna2);
//
//                Set<Bidder> bidders = new HashSet<>();
//        bidders.add( ana1);
//        bidders.add(new Bidder("Mary", BigDecimal.valueOf(20_000_000)));
//        bidders.add( new Bidder("John", BigDecimal.valueOf(10_000_000)));
//        bidders.add (new Bidder("Ana", BigDecimal.valueOf(15_000_000)));
//                bidders.add(ana2);
//
//        int size = bidders.size();
//        System.out.println("size = " + size );

     Orchestrator orchestrator = new Orchestrator(
                List.of(
                        new Lot("Toyota Rav4", new BigDecimal(15_000)),
                        new Lot("WW Tiguan", new BigDecimal(25_000))
                ),
                List.of (new Bidder("Mary", new BigDecimal(75_000)),
                        new Bidder("Jon",new BigDecimal(50_000))
                )
        );
     System.out.printf("Auction thread name=[%s], priority=[%s], state=[%s]\n",
             Thread.currentThread().getName(),
        Thread.currentThread().getPriority(),
        Thread.currentThread().getState());





     AuctionProcess auctionProcess = orchestrator.startAuction();


     log.info("Auction is started");
     auctionProcess.waitForFinish();
     log.info("Auction is finished");
   }

}

