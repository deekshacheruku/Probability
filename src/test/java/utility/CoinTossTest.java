package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTossTest {
    @Test
    void testIfProbabilityOfHeadEqualsProbabilityOfTail() {
        CoinToss head = new CoinToss(CoinToss.Coin.HEAD);
        CoinToss tail = new CoinToss(CoinToss.Coin.TAIL);

        assertEquals(head, tail);
    }
}
