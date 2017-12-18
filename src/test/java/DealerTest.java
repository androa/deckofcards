import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DealerTest {
  private Dealer dealer;

  @Before
  public void setUp() {
    Deck deck = new Deck();

    deck.addCard(new Card("HEARTS", "1"));
    deck.addCard(new Card("SPADES", "Q"));

    this.dealer = new Dealer(deck);
  }

  @Test
  public void testDealerDealsCards() {
    Integer cardsDealt = this.dealer.dealCards(2).size();

    Integer expectedValue = 2;

    assertEquals("Dealer should give us two cards", expectedValue, cardsDealt);
  }

  @Test
  public void testDealerRefusesWhenOutOfCards() {
    // We need to handle that the deck runs out of card
  }
}
