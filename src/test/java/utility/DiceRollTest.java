package utility;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceRollTest {
    static DiceRoll firstEvent, secondEvent, thirdEvent;
    static Probability expectedProbability;
    static Probability actualProbability;
    static int timesRolled;

    @BeforeAll
    static void initializations() {
        firstEvent = new DiceRoll(DiceRoll.Dice.ONE);
        secondEvent = new DiceRoll(DiceRoll.Dice.TWO);
        thirdEvent = new DiceRoll(DiceRoll.Dice.THREE);
    }

    @Test
    void testIfProbabilityOfRollingOneIsEqualToProbabilityOfRollingTwo() {
        timesRolled = 1;
        Probability rollingOneProbability = firstEvent.event(null, timesRolled);
        Probability rollingTwoProbability = thirdEvent.event(null, timesRolled);

        assertEquals(rollingOneProbability, rollingTwoProbability);
    }

    @Test
    void testIfProbabilityOfRollingOneAndRollingTwoEventsOccurringTogetherIs0_06() {
        timesRolled = 2;
        expectedProbability = new Probability(0.06);
        actualProbability = firstEvent.event(secondEvent, timesRolled);

        assertEquals(expectedProbability, actualProbability);
    }

    @Test
    void testIfProbabilityOfRollingThreeAndRollingThreeEventsOccurringTogetherIs0_03() {
        timesRolled = 2;
        expectedProbability = new Probability(0.03);
        actualProbability = thirdEvent.event(thirdEvent, timesRolled);

        assertEquals(expectedProbability, actualProbability);
    }

    @Test
    void testIfProbabilityOfRollingFourEventNotOccurringIs0_17() {
        timesRolled = 1;
        expectedProbability = new Probability(0.17);
        actualProbability = firstEvent.eventNotOccurred(timesRolled);

        assertEquals(expectedProbability, actualProbability);
    }
}
