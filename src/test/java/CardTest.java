import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {
  @Test public void testNumericalCardHoldsValue() {
    String suite = "HEARTS";
    String value = "10";
    Card card = new Card(suite, value);

    Integer expectedValue = 10;
    assertEquals(
      "Numerical cards should be numerical",
      expectedValue,
      card.getNumericalValue()
    );
  }

  @Test public void testFaceCardHoldsValue() {
    String suite = "HEARTS";
    String value = "Q";
    Card card = new Card(suite, value);

    Integer expectedValue = 10;
    assertEquals(
      "Queen should be equal to 10",
      expectedValue,
      card.getNumericalValue()
    );
  }
}
