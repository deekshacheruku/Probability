package utility;

import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class DiceRoll {
    public enum Dice {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX;

        private final int totalStates = 6;

        public int getTotalStates() {
            return totalStates;
        }

        int getSampleSpace(int timesRolled) {
            return (int) pow(totalStates, timesRolled);
        }
    }

    private final DiceRoll.Dice rollState;

    public DiceRoll(DiceRoll.Dice rollState) {
        this.rollState = rollState;
    }

    int getPossibleOutcomes(Object obj) {
        DiceRoll event = (DiceRoll) obj;
        if (event == null || this.rollState.equals(event.rollState))
            return 1;
        return 2;
    }

    public Probability event(Object event, int timesRolled) {
        DecimalFormat df = new DecimalFormat("#.##");
        double result = getPossibleOutcomes(event) / (double) rollState.getSampleSpace(timesRolled);
        return new Probability(Double.parseDouble(df.format(result)));
    }

    public Probability eventNotOccurred(int timesRolled) {
        DecimalFormat df = new DecimalFormat("#.##");
        double result = 1 - ((rollState.getTotalStates() - 1) / (double) rollState.getSampleSpace(timesRolled));
        return new Probability(Double.parseDouble(df.format(result)));
    }
}
