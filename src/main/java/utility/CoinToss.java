package utility;

import static java.lang.Math.pow;

public class CoinToss {
    public enum Coin {
        HEAD(),
        TAIL();

        int getSampleSpace(int timesTossed) {
            return (int) pow(2, timesTossed);
        }
    }

    private final Coin tossState;

    public CoinToss(Coin tossState) {
        this.tossState = tossState;
    }

    int getPossibleOutcomes(Object obj) {
        CoinToss event = (CoinToss) obj;
        if (event == null || this.tossState.equals(event.tossState))
            return 1;
        return 2;
    }

    public Probability event(Object event, int timesTossed) {
        return new Probability(getPossibleOutcomes(event) / (double) tossState.getSampleSpace(timesTossed));
    }

    public Probability eventNotOccurred(Object event, int timesTossed) {
        return new Probability(1 - (this.event(event, timesTossed)).getProbabilityValue());
    }

}
