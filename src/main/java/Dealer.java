import java.util.LinkedHashSet;

public class Dealer {
  private Deck deck;

  public Dealer(Deck deck) {
    this.deck = deck;
  }

  public LinkedHashSet dealCards(int numberOfCards) {
    LinkedHashSet cards = new LinkedHashSet();

    for (int i = 1; i <= numberOfCards; i++) {
      cards.add(this.deck.drawCard());
    }

    return cards;
  }
}
