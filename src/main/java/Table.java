import java.util.Collection;

import java.util.Collections;

import java.util.Iterator;

import java.util.Optional;

import java.util.LinkedHashSet;

import java.util.LinkedList;

import java.util.stream.Collectors;

public class Table {
  final private int INITIAL_DRAW = 2;
  final private int INITIAL_SCORE_TO_BEAT = 17;
  private Dealer dealer;
  private LinkedHashSet<Player> players = new LinkedHashSet();

  public String status = null;

  public Table(Dealer dealer) {
    this.dealer = dealer;
  }

  public Table seatPlayer(Player player) {
    this.players.add(player);
    return this;
  }

  public Player playRound() {
    Player winner = null;

    int cardsToDraw = INITIAL_DRAW;
    boolean hasActivePlayers = false;

    do {
      int scoreToBeat = this.getScoreToBeat(this.players);
      Collection<Player> players = this.getActivePlayers(this.players, scoreToBeat);

      for (Player player : players) {
        Collection cards = dealer.dealCards(cardsToDraw);

        player.recieveCards(cards);
      }

      cardsToDraw = 1;

      hasActivePlayers = players.size() != 0;
    } while (hasActivePlayers);

    winner = this.getWinner(this.players);

    return winner;
  }

  private int getScoreToBeat(Collection<Player> players) {
    return players.stream()
      .mapToInt(player -> player.getCurrentScore())
      .filter(score -> score > this.INITIAL_SCORE_TO_BEAT)
      .filter(score -> score < 21)
      .max()
      .orElse(this.INITIAL_SCORE_TO_BEAT);
  }

  private Collection<Player> getActivePlayers(Collection<Player> players, int scoreToBeat) {
    return players.stream()
      .filter(p -> p.getNextPlay(scoreToBeat) != "stand")
      .collect(Collectors.toCollection(LinkedHashSet<Player>::new));
  }

  private Player getWinner(Collection<Player> players) {
    return players.stream()
      .filter(p -> p.getCurrentScore() <= 21)
      .limit(1)
      .findFirst()
      .get();
  }
}
