public class Card {
  private String suite;
  private String value;

  public Card(String suite, String value) {
    this.suite = suite;
    this.value = value;
  }

  public Integer getNumericalValue() {
    switch (this.value) {
      case "J":
      case "Q":
      case "K":
        return 10;
      case "A":
        return 11;
      default:
        return Integer.parseInt(this.value);
    }
  }

  public String toString() {
    return this.suite.charAt(0) + this.value;
  }
}
