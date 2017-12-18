import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardTest {
  @Test
  public void testNumericalCardHoldsValue() {
    Card card = new Card("HEARTS", "10");

    Integer expectedValue = 10;
    assertEquals("Numerical cards should be numerical", expectedValue, card.getNumericalValue());
  }

  @Test
  public void testFaceCardHoldsValue() {
    Card card = new Card("SPADES", "Q");

    Integer expectedValue = 10;
    assertEquals("Queen should be equal to 10", expectedValue, card.getNumericalValue());
  }
}
