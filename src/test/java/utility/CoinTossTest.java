package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTossTest {
    @Test
    void testIfProbabilityOfHeadEqualsProbabilityOfTail() {
        CoinToss head = new CoinToss("Head");
        CoinToss tail = new CoinToss("Tail");

        assertEquals(head,tail);
    }
}
