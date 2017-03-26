import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AppTest {
  @Test public void testAppPlaysBlackjack() {
    App classUnderTest = new App();
    assertNotNull("Blackjack has been played", classUnderTest.playBlackjack());
  }
}
