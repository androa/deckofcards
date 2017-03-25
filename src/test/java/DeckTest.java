import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class DeckTest {
  @Test public void testDeckHoldsCards() {
    Deck deck = new Deck();

    deck.addCard(new Card("HEARTS", "1"));
    deck.addCard(new Card("SPADES", "Q"));

    Integer expectedValue = 2;
    assertEquals("Deck should hold two cards", expectedValue, deck.cardsLeft());
  }

  @Test public void testDeckReducesAfterDraw() {
    Deck deck = new Deck();

    deck.addCard(new Card("HEARTS", "1"));
    deck.addCard(new Card("SPADES", "Q"));

    deck.drawCard();

    Integer expectedValue = 1;
    assertEquals("Deck should hold one card", expectedValue, deck.cardsLeft());
  }

  @Test public void testDeckDrawsInOrder() {
    Deck deck = new Deck();

    Card card1 = new Card("HEARTS", "1");
    deck.addCard(card1);
    deck.addCard(new Card("SPADES", "Q"));

    Card drawnCard = deck.drawCard();

    Card expectedValue = card1;
    assertSame("Deck drew first card", expectedValue, drawnCard);
  }
}
