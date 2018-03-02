
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AuctionTest {

    @Test
    void equalityStrategyOpponent() {

        //adjust
        Bid bid = new Bid();
        int quantity = 8;
        int cash = 6;
        int otherCash = 1;
        int expectedWinQuantity = 6;
        //action
        bid.init(quantity, cash);
        while (quantity != 0) {
            bid.bids(bid.placeBid(), otherCash);
            quantity -= 2;
        }
        int actualWinQuantity = bid.getParticipant().getWinQuantity();
        //assert
        assert (expectedWinQuantity == actualWinQuantity);

    }

    @Test
    void decreaseStrategyOpponent() {
        //adjust
        Bid bid = new Bid();
        int quantity = 8;
        int cash = 6;
        int otherCash = 6;
        int expectedWinQuantity = 0;
        //action
        bid.init(quantity, cash);
        while (quantity != 0) {
            bid.bids(bid.placeBid(), otherCash);
            quantity -= 2;
            otherCash -= 1;
        }
        int actualWinQuantity = bid.getParticipant().getWinQuantity();
        //assert
        assert (expectedWinQuantity == actualWinQuantity);
    }

    @Test
    void increaseStrategyOpponent() {
        //adjust
        Bid bid = new Bid();
        int quantity = 8;
        int cash = 6;
        int otherCash = 1;
        int expectedWinQuantity = 1;
        //action
        bid.init(quantity, cash);
        while (quantity != 0) {
            bid.bids(bid.placeBid(), otherCash);
            quantity -= 2;
            otherCash += 1;
        }
        int actualWinQuantity = bid.getParticipant().getWinQuantity();
        //assert
        assert (expectedWinQuantity == actualWinQuantity);
    }

}
