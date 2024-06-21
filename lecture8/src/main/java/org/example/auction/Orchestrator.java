package org.example.auction;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Value
public class Orchestrator {

    List<Lot> lots;
    List<Bidder> bidders;

    public Orchestrator(List<Lot> lots, List<Bidder> bidders) {
        this.lots = lots;
        this.bidders = bidders;
        log.info("Create Orchestrator with " + lots.size() + " lots and "+ bidders.size() +" bidders" );
    }

    public AuctionProcess startAuction() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //TODO impl auction process
                log.info("[%s] Auction is started in separate thread");
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                   log.warn("Auction process is interrupted unexpectedly");
                }
//                System.out.println("I am not done yet!");
                log.info("Auction process is done");
            }
        });
        thread.setName("auction-process");
        thread.setDaemon(true);
        thread.start();
//        log.info("Start auction");
//        try {
//            Thread.sleep(2_000);
//        } catch (InterruptedException ignored) {
//        }
//
//        thread.interrupt();

//        thread.interrupt();
        return  new AuctionProcess(new AuctionWaiter() {
            @Override
            public void WaitForComleteness() {
                try {
                    thread.join();
                } catch (InterruptedException ignored) {

                }
            }
        });
    }
}
