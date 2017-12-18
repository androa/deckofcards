import java.util.LinkedHashSet;

public class App {
  public String playBlackjack() {
    Blackjack blackjack = new Blackjack(this.getShuffleEndpoint());

    // TODO: Collect players name through stdin
    LinkedHashSet<Player> players = new LinkedHashSet<Player>();
    players.add(new Player("André"));
    players.add(new Player("Magnus"));

    blackjack.seatPlayers(players);

    Result result = blackjack.play();
    Player winner = result.getWinner();

    StringBuilder prettyResult =
        new StringBuilder()
            .append("Vinner: ")
            .append(winner.getName())
            .append("\n\n")
            .append("Resultat:\n");

    result
        .getPlayers()
        .forEach(
            p ->
                prettyResult
                    .append(p.getName())
                    .append(" | ")
                    .append(p.getCurrentScore())
                    .append(" | ")
                    .append(p.getHand())
                    .append("\n"));

    return prettyResult.toString();
  }

  private String getShuffleEndpoint() {
    String endpoint = System.getenv("SHUFFLE_ENDPOINT");
    if (endpoint == null) {
      endpoint = "http://nav-deckofcards.herokuapp.com/shuffle";
    }

    return endpoint;
  }

  public static void main(String[] args) {
    System.out.println(new App().playBlackjack());
  }
}
