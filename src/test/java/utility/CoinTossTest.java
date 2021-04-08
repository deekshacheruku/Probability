package utility;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTossTest {
    static CoinToss headFirstEvent, headSecondEvent, tailFirstEvent, tailSecondEvent;
    static double expectedProbability;
    static double actualProbability;

    @BeforeAll
    static void initializations() {
        headFirstEvent = new CoinToss(CoinToss.Coin.HEAD);
        headSecondEvent = new CoinToss(CoinToss.Coin.HEAD);
        tailFirstEvent = new CoinToss(CoinToss.Coin.TAIL);
        tailSecondEvent = new CoinToss(CoinToss.Coin.TAIL);
    }

    @Test
    void testIfProbabilityOfHeadEqualsProbabilityOfTail() {
        assertEquals(headFirstEvent, tailFirstEvent);
    }

    @Test
    void testIfProbabilityOfHeadAndHeadEventsOccurringTogetherIs0_25() {
        expectedProbability = 0.25;
        actualProbability = headFirstEvent.eventTogether(headSecondEvent);

        assertEquals(expectedProbability, actualProbability);
    }

    @Test
    void testIfProbabilityOfTailAndTailEventsOccurringTogetherIs0_25() {
        expectedProbability = 0.25;
        actualProbability = tailFirstEvent.eventTogether(tailSecondEvent);

        assertEquals(expectedProbability, actualProbability);
    }

    @Test
    void testIfProbabilityOfHeadAndTailEventsOccurringTogetherIs0_5() {
        expectedProbability = 0.5;
        actualProbability = headFirstEvent.eventTogether(tailSecondEvent);

        assertEquals(expectedProbability, actualProbability);
    }

    @Test
    void testIfProbabilityOfTailAndHeadEventsOccurringTogetherIs0_5() {
        expectedProbability = 0.5;
        actualProbability = tailFirstEvent.eventTogether(headSecondEvent);

        assertEquals(expectedProbability, actualProbability);
    }
}