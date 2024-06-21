package org.example.auction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuctionProcess {
    private final AuctionWaiter auctionWaiter;

    public AuctionProcess(AuctionWaiter auctionWaiter) {
        this.auctionWaiter = auctionWaiter;
    }

    public void waitForFinish() {
        log.info("Asking to wait for auction finish");
        auctionWaiter.WaitForComleteness();
        log.info("Auction finish is done");
    }
}
