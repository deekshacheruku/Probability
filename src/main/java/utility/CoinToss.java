package utility;

public class CoinToss {
    private final String tossState;

    public CoinToss(String tossState) {
        this.tossState = tossState;
    }

    private double getProbability(){
        return 0.5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinToss coinToss = (CoinToss) o;
        return Double.compare(coinToss.getProbability(), getProbability()) == 0;
    }
}
