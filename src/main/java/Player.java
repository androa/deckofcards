import java.util.Collection;
import java.util.Collections;
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

  public Collection<Card> getHand() {
    return Collections.unmodifiableCollection(this.hand);
  }

  public void recieveCards(Collection cards) {
    this.hand.addAll(cards);
  }

  public Integer getCurrentScore() {
    return this.hand
        .stream()
        .map(card -> card.getNumericalValue())
        .reduce(0, (sum, cardValue) -> sum += cardValue, (sum1, sum2) -> sum1 + sum2);
  }

  public String getNextPlay(int scoreToBeat) {
    String nextPlay = null;
    int score = this.getCurrentScore();

    if (score == 21) {
      nextPlay = "stand";
    } else if (score < scoreToBeat) {
      nextPlay = "hit";
    } else if (score >= scoreToBeat) {
      nextPlay = "stand";
    }

    return nextPlay;
  }
}
