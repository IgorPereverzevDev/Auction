import lombok.Getter;

class Participant {

    @Getter
    private int cash;
    @Getter
    private int winQuantity;
    @Getter
    private int quantity;
    private int amountPerRound;
    private int zeroRounds;
    private int roundError;


    void initCashAndQuantity(int quantity, int cash) {
        if (quantity != 0) {
            this.quantity = quantity;
            this.cash = cash;
            if (cash != 0) {
                initAmountPerRound();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void initAmountPerRound() {
        final int pairQuantity = 2;
        int numberOfRounds = quantity / pairQuantity;
        int remainOfRounds = (numberOfRounds + 2) / 2;
        zeroRounds = numberOfRounds - remainOfRounds;
        amountPerRound = cash / remainOfRounds;
        roundError = cash % remainOfRounds;
    }

    void calculateWinsQuantity(int own, int other) {
        if (own == other) {
            ++winQuantity;
        } else if (own > other) {
            winQuantity += 2;
        }
    }

    int getAmountPerRound() {
        if (zeroRounds == 0) {
            int amount = amountPerRound + roundError;
            if (roundError > 0) {
                --roundError;
            }
            return amount;
        }
        --zeroRounds;
        return 0;
    }
}


