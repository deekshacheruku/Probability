package utility;

import static java.lang.Math.pow;

public class DiceRoll extends Event<DiceRoll> {
    public enum Dice implements Type {
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

        public int getSampleSpace(int timesRolled) {
            return (int) pow(totalStates, timesRolled);
        }
    }

    public DiceRoll(Dice rollState) {
        super(rollState);
    }
}
