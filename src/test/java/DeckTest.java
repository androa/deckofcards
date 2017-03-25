import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {
  @Test public void testDeckHoldsCards() {
    Deck deck = new Deck();

    deck.addCard(new Card("HEARTS", "1"));
    deck.addCard(new Card("SPADES", "Q"));

    Integer expectedValue = 2;
    assertEquals(
      "Deck should hold two cards",
      expectedValue,
      deck.cardsLeft()
    );
  }
}
