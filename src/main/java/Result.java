import java.util.Collection;
import java.util.LinkedHashSet;

public class Result {
  private LinkedHashSet<Player> players = new LinkedHashSet();

  public Result(LinkedHashSet<Player> players) {
    this.players = players;
  }

  public Collection<Player> getPlayers() {
    return this.players;
  }

  public Player getWinner() {
    return this.players.stream().filter(p -> p.getCurrentScore() <= 21).limit(1).findFirst().get();
  }
}
