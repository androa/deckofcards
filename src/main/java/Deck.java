import java.util.LinkedList;

public class Deck {
  private LinkedList<Card> cards = new LinkedList();

  public Deck addCard(Card card) {
    this.cards.add(card);
    return this;
  }

  public Integer cardsLeft() {
    return this.cards.size();
  }

  public Card drawCard() {
    return this.cards.poll();
  }
}
