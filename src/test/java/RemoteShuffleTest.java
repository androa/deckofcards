import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RemoteShuffleTest {
  @Test
  public void itShufflesCards() {
    Shuffle shuffle = new RemoteShuffle("http://nav-deckofcards.herokuapp.com/shuffle");
    Deck deck = new Deck();

    shuffle.shuffle(deck);

    assertTrue(deck.cardsLeft() == 52);
  }
}
