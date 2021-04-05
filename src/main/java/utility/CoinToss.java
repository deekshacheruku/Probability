package utility;

import java.util.Objects;

public class CoinToss {
    public enum Coin {
        HEAD,
        TAIL
    }

    final Coin tossState;

    public CoinToss(Coin tossState) {
        this.tossState = tossState;
    }

    private double getProbability() {
        return 0.5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinToss coinToss = (CoinToss) o;
        return Double.compare(coinToss.getProbability(), getProbability()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProbability());
    }
}
