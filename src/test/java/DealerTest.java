import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Collection;
import java.util.LinkedHashSet;

public class DealerTest {
  @Test public void testDealerDealsCards() {
    Deck deck = new Deck();

    Card card1 = new Card("HEARTS", "1");
    Card card2 = new Card("SPADES", "Q");

    deck.addCard(card1);
    deck.addCard(card2);

    Dealer dealer = new Dealer(deck);

    Integer expectedValue = 2;

    Integer cardsDealt = dealer.dealCards(expectedValue).size();

    assertEquals(
      "Dealer should give us two cards",
      expectedValue,
      cardsDealt
    );
  }

  @Test public void testDealerDealsCardsInExpectedOrder() {
    Deck deck = new Deck();

    Card card1 = new Card("HEARTS", "1");
    Card card2 = new Card("SPADES", "Q");

    deck.addCard(card1);
    deck.addCard(card2);

    Dealer dealer = new Dealer(deck);

    Collection cards = dealer.dealCards(2);

    Collection expectedValue = new LinkedHashSet();
    expectedValue.add(card1);
    expectedValue.add(card2);

    //fail("This test does not do a deep compare");
    assertEquals(
      "Dealer should give us two cards",
      expectedValue,
      cards
    );
  }

  @Test public void testDealerRefusesWhenOutOfCards() {
  }
}
