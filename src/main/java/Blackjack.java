import java.util.Collection;

public class Blackjack {
  private Shuffle shuffle;
  private Deck deck;
  private Table table;

  public Blackjack(String shuffleEndpoint) {
    // TODO: Implement a factory that can change implementation and inject
    // different implementations
    this.shuffle = new RemoteShuffle(shuffleEndpoint);
    this.deck = new Deck();

    Dealer dealer = new Dealer(deck);
    this.table = new Table(dealer);
  }

  public void seatPlayers(Collection<Player> players) {
    players.forEach(player -> this.table.seatPlayer(player));
  }

  public Result play() {
    this.shuffle.shuffle(this.deck);

    return table.playRound();
  }
}
