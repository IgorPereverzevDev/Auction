import org.junit.jupiter.api.Test;

class AuctionTestStrategiesOfOpponent {
    @Test
    void OpponentStrategyEquality() {
        //adjust
        Bid bid = new Bid();
        int quantity = 8;
        int cash = 6;
        int otherCash = 2;
        int expectedWinQuantity = 3;
        //act
        bid.init(quantity, cash);
        while (quantity != 0) {
            bid.bids(bid.placeBid(), otherCash);
            quantity -= 2;
        }
        int actualWinQuantity = bid.getParticipant().getWinQuantity();
        //assert
        assert (expectedWinQuantity == actualWinQuantity);
    }
}
