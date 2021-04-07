package utility;

import java.util.Objects;

public class CoinToss {
    public enum Coin {
        HEAD(0.5),
        TAIL(0.5);

        private final double probability;

        Coin(double probability) {
            this.probability = probability;
        }

        private double getProbability() {
            return this.probability;
        }
    }

    private final Coin tossState;

    public CoinToss(Coin tossState) {
        this.tossState = tossState;
    }

    public double eventTogether(CoinToss event) {
        return tossState.getProbability() * event.tossState.getProbability();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinToss coinToss = (CoinToss) o;
        return Double.compare(coinToss.tossState.getProbability(), tossState.getProbability()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tossState);
    }
}
