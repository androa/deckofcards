import java.util.LinkedHashSet;

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
