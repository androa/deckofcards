import java.util.Collection;

import java.util.HashSet;

public class Player {
  private String name;
  private HashSet<Card> hand = new HashSet();

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void recieveCards(Collection cards) {
    this.hand.addAll(cards);
  }

  public Integer getCurrentScore() {
    Integer score = this.hand
      .stream()
      .map(card -> card.getNumericalValue())
      .reduce(0, (sum, cardValue) -> sum += cardValue, (sum1, sum2) -> sum1 + sum2);

    return score;
  }
}
