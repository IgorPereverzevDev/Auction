import org.junit.jupiter.api.Test;



class AuctionTestStrategiesOfOwn {

    @Test
    void decreaseStrategyOwn() {
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
            cash -= 1;
        }
        int actualWinQuantity = bid.getParticipant().getWinQuantity();
        //assert
        assert (expectedWinQuantity == actualWinQuantity);
    }

    @Test
    void increaseStrategyOwn() {
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