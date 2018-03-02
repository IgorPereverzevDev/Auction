import lombok.Getter;

import java.util.logging.Logger;

public class Bid implements Bidder {

    @Getter
    private Participant participant = new Participant();

    private final static Logger LOG = Logger.getLogger(Bid.class.getName());

    public void init(int quantity, int cash) {
        participant.initCashAndQuantity(quantity, cash);
    }

    public int placeBid() {
        return participant.getAmountPerRound();
    }

    public void bids(int own, int other) {
        LOG.info("this bid: " + own + " other bid: " + other);
        participant.calculateWinsQuantity(own, other);
    }

}
