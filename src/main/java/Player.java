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

  public Player recieveCards(Collection cards) {
    this.hand.addAll(cards);
    return this;
  }

  public Integer getCurrentScore() {
    Integer score = this.hand
      .stream()
      .map(card -> card.getNumericalValue())
      .reduce(0, (sum, cardValue) -> sum += cardValue, (sum1, sum2) -> sum1 + sum2);
    /*this.hand.forEach((Card card) -> {
      score += card.getNumericalValue();
    });*/

    return score;
  }
}
