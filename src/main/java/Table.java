import java.util.Collection;

import java.util.Collections;

import java.util.Iterator;

import java.util.Optional;

import java.util.LinkedHashSet;

import java.util.LinkedList;

import java.util.stream.Collectors;

public class Table {
  private Dealer dealer;
  private LinkedHashSet<Player> players = new LinkedHashSet();

  public Table(Dealer dealer) {
    this.dealer = dealer;
  }

  public void seatPlayer(Player player) {
    this.players.add(player);
  }

  public Result playRound() {
    Round round = new Round(this.dealer, this.players);

    return round.play();
  }
}
