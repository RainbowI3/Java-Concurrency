package org.example.auction;

import org.example.auction.Lot;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Java6Assertions.assertThat;

class LotTest {

    @Test
    public void createLot(){
        Lot lot = new Lot("raw-4",new BigDecimal(100000));
        assertThat(lot.name()).isEqualTo("raw-4");
    }
}