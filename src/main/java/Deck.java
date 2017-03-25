import java.util.ArrayList;

public class Deck {
  private ArrayList<Card> cards = new ArrayList();

  public Deck addCard(Card card) {
    this.cards.add(card);
    return this;
  }

  public Integer cardsLeft() {
    return this.cards.size();
  }
}
