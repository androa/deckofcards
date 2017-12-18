import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import org.junit.Test;

public class ResultTest {
  @Test
  public void testResultsHoldsPlayers() {
    LinkedHashSet<Player> players = new LinkedHashSet();
    Player p1 = new Player("André");
    Player p2 = new Player("Magnus");
    players.add(p1);
    players.add(p2);

    Result result = new Result(players);

    assertTrue("Result contains all the players", result.getPlayers().contains(p1));
    assertTrue("Result contains all the players", result.getPlayers().contains(p2));
  }
}
