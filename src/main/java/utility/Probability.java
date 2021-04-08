package utility;

import java.util.Objects;

public class Probability {
    private final double probabilityValue;

    public Probability(double probability) {
        this.probabilityValue = probability;
    }

    public double getProbabilityValue() {
        return probabilityValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability probability = (Probability) o;
        return Double.compare(probability.probabilityValue, probabilityValue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(probabilityValue);
    }
}
