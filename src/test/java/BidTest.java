import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BidTest {

    @Test
    void init() {
        //adjust
        Bid bid = new Bid();
        int quantity = 8;
        int cash = 6;

        //expected value
        int expectedQuantity = 8;
        int expectedCash = 6;

        //act
        bid.init(quantity, cash);
        int actualCash = bid.getParticipant().getCash();
        int actualQuantity = bid.getParticipant().getQuantity();
        //assert
        Assertions.assertAll(
                () -> assertTrue(expectedCash == actualCash),
                () -> assertTrue(expectedQuantity == actualQuantity));
    }

    @Test
    void placeBid() {
        //adjust
        Bid bid = new Bid();
        int quantity = 8;
        int cash = 6;
        int expectedAmountPerRound = 0;
        //act
        bid.init(quantity, cash);
        int actualAmountPerRound = bid.placeBid();
        //assert
        assert (expectedAmountPerRound == actualAmountPerRound);
    }
}