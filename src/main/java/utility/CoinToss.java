package utility;

import static java.lang.Math.pow;

public class CoinToss extends Event<CoinToss> {
    public enum Coin implements Type {
        HEAD(),
        TAIL();

        private final int totalStates = 2;

        public int getTotalStates() {
            return totalStates;
        }

        public int getSampleSpace(int timesTossed) {
            return (int) pow(totalStates, timesTossed);
        }
    }

    public CoinToss(Coin tossState) {
        super(tossState);
    }
}
