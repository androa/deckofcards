import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import org.junit.Test;

import java.util.HashSet;

public class PlayerTest {
  private Player player;
  private HashSet<Card> cards = new HashSet();

  @Before public void setUp() {
    this.player = new Player("test");

    this.cards.add(new Card("HEARTS", "1"));
    this.cards.add(new Card("SPADES", "Q"));

    this.player.recieveCards(this.cards);
  }

  @Test public void testPlayerCanSum() {
    Integer expectedValue = 11;
    Integer currentScore = this.player.getCurrentScore();
    assertEquals("Dealer should give us two cards", expectedValue, currentScore);
  }

  @Test public void testPlayersShowTheirHand() {
    Object[] expectedValue = this.cards.toArray();
    Object[] hand = this.player.getHand().toArray();
    assertArrayEquals("Dealer should give us two cards", expectedValue, hand);
  }
}
