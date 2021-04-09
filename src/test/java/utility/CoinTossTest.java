package utility;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTossTest {
    static CoinToss headFirstEvent, headSecondEvent, tailFirstEvent, tailSecondEvent;
    static Probability expectedProbability;
    static Probability actualProbability;
    static int timesTossed;

    @BeforeAll
    static void initializations() {
        headFirstEvent = new CoinToss(CoinToss.Coin.HEAD);
        headSecondEvent = new CoinToss(CoinToss.Coin.HEAD);
        tailFirstEvent = new CoinToss(CoinToss.Coin.TAIL);
        tailSecondEvent = new CoinToss(CoinToss.Coin.TAIL);
    }

    @Test
    void testIfProbabilityOfHeadEqualsProbabilityOfTail() {
        timesTossed = 1;
        Probability headProbability = headFirstEvent.event(null, timesTossed);
        Probability tailProbability = tailFirstEvent.event(null, timesTossed);

        assertEquals(headProbability, tailProbability);
    }

    @Test
    void testIfProbabilityOfHeadAndHeadEventsOccurringTogetherIs0_25() {
        timesTossed = 2;
        expectedProbability = new Probability(0.25);
        actualProbability = headFirstEvent.event(headSecondEvent, timesTossed);

        assertEquals(expectedProbability, actualProbability);
    }

    @Test
    void testIfProbabilityOfTailAndTailEventsOccurringTogetherIs0_25() {
        timesTossed = 2;
        expectedProbability = new Probability(0.25);
        actualProbability = tailFirstEvent.event(tailSecondEvent, timesTossed);

        assertEquals(expectedProbability, actualProbability);
    }

    @Test
    void testIfProbabilityOfHeadAndTailEventsOccurringTogetherIs0_5() {
        timesTossed = 2;
        expectedProbability = new Probability(0.5);
        actualProbability = headFirstEvent.event(tailSecondEvent, timesTossed);

        assertEquals(expectedProbability, actualProbability);
    }

    @Test
    void testIfProbabilityOfTailAndHeadEventsOccurringTogetherIs0_5() {
        timesTossed = 2;
        expectedProbability = new Probability(0.5);
        actualProbability = tailFirstEvent.event(headSecondEvent, timesTossed);

        assertEquals(expectedProbability, actualProbability);
    }

    @Test
    void testIfProbabilityOfTailEventNotOccurringIs0_5() {
        timesTossed = 1;
        expectedProbability = new Probability(0.5);
        actualProbability = headFirstEvent.eventNotOccurred(timesTossed);

        assertEquals(expectedProbability, actualProbability);
    }

    @Test
    void testIfProbabilityOfHeadEventNotOccurringIs0_5() {
        timesTossed = 1;
        expectedProbability = new Probability(0.5);
        actualProbability = tailFirstEvent.eventNotOccurred(timesTossed);

        assertEquals(expectedProbability, actualProbability);
    }


}