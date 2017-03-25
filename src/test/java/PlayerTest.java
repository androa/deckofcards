import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import java.util.Collection;

import java.util.HashSet;

public class PlayerTest {
  private Player player;

  @Before public void setUp() {
    this.player = new Player("test");

    HashSet cards = new HashSet();;
    cards.add(new Card("HEARTS", "1"));
    cards.add(new Card("SPADES", "Q"));

    this.player.recieveCards(cards);
  }

  @Test public void testPlayerCanSum() {
    Integer expectedValue = 11;
    Integer currentScore = this.player.getCurrentScore();
    assertEquals(
      "Dealer should give us two cards",
      expectedValue,
      currentScore
    );
  }
}
