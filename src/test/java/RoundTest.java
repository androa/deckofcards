import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.LinkedHashSet;
import org.junit.Test;

public class RoundTest {
  @Test
  public void testWinOnBlackjack() {
    Deck deck = new Deck();
    deck.addCard(new Card("HEARTS", "1"));
    deck.addCard(new Card("SPADES", "Q"));
    deck.addCard(new Card("SPADES", "Q"));
    deck.addCard(new Card("SPADES", "Q"));
    deck.addCard(new Card("SPADES", "Q"));

    LinkedHashSet<Player> players = new LinkedHashSet();
    Player expectedWinner = new Player("André");
    players.add(expectedWinner);
    players.add(new Player("Magnus"));

    Dealer dealer = new Dealer(deck);
    Round round = new Round(dealer, players);

    Player winner = round.play().getWinner();

    int expectedScore = 21;

    assertEquals("Winning score is 21", expectedScore, (int) winner.getCurrentScore());
    assertSame("The winner is André", expectedWinner, winner);
  }

  @Test
  public void testWinOn19() {
    Deck deck = new Deck();
    deck.addCard(new Card("HEARTS", "1")); // André
    deck.addCard(new Card("SPADES", "Q")); // André
    deck.addCard(new Card("SPADES", "8")); // Magnus
    deck.addCard(new Card("SPADES", "8")); // Magnus
    deck.addCard(new Card("SPADES", "8")); // André
    deck.addCard(new Card("SPADES", "Q")); // Magnus
    deck.addCard(new Card("SPADES", "2")); // André
    deck.addCard(new Card("SPADES", "3")); // Magnus

    LinkedHashSet<Player> players = new LinkedHashSet();
    Player expectedWinner = new Player("André");
    players.add(expectedWinner);
    players.add(new Player("Magnus"));

    Dealer dealer = new Dealer(deck);
    Round round = new Round(dealer, players);

    Player winner = round.play().getWinner();

    int expectedScore = 19;

    assertSame("The winner is André", expectedWinner, winner);
    assertEquals("Winning score is 19", expectedScore, (int) winner.getCurrentScore());
  }
}
