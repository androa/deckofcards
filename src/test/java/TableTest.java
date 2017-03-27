import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class TableTest {
  @Test public void testWinOnBlackjack() {
    Deck deck = new Deck();
    deck.addCard(new Card("HEARTS", "1"));
    deck.addCard(new Card("SPADES", "Q"));
    deck.addCard(new Card("SPADES", "Q"));
    deck.addCard(new Card("SPADES", "Q"));
    deck.addCard(new Card("SPADES", "Q"));

    Dealer dealer = new Dealer(deck);
    Table table = new Table(dealer);

    Player expectedWinner = new Player("André");
    table.seatPlayer(expectedWinner);
    table.seatPlayer(new Player("Magnus"));

    Player winner = table.playRound().getWinner();

    int expectedScore = 21;

    assertEquals("Winning score is 21", expectedScore, (int) winner.getCurrentScore());
    assertSame("The winner is André", expectedWinner, winner);
  }

  @Test public void testWinOn19() {
    Deck deck = new Deck();
    deck.addCard(new Card("HEARTS", "1")); // André
    deck.addCard(new Card("SPADES", "Q")); // André
    deck.addCard(new Card("SPADES", "8")); // Magnus
    deck.addCard(new Card("SPADES", "8")); // Magnus
    deck.addCard(new Card("SPADES", "8")); // André
    deck.addCard(new Card("SPADES", "Q")); // Magnus

    Dealer dealer = new Dealer(deck);
    Table table = new Table(dealer);

    Player expectedWinner = new Player("André");
    table.seatPlayer(expectedWinner);
    table.seatPlayer(new Player("Magnus"));

    Player winner = table.playRound().getWinner();

    int expectedScore = 19;

    assertSame("The winner is André", expectedWinner, winner);
    assertEquals("Winning score is 19", expectedScore, (int) winner.getCurrentScore());
  }
}
