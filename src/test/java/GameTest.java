import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void shouldWorkIfFirstPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(12, "Will", 500);
        Player player2 = new Player(15, "Sam", 80);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Will", "Sam");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldWorkIfSecondPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(12, "Will", 50);
        Player player2 = new Player(15, "Sam", 800);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Will", "Sam");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldWhenPlayersAreEqual() {
        Game game = new Game();
        Player player1 = new Player(12, "Will", 80);
        Player player2 = new Player(15, "Sam", 80);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Will", "Sam");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldThrowExceptionWhenFirstPlayerIsNotRegister() {
        Game game = new Game();
        Player player1 = new Player(12, "Will", 80);
        Player player2 = new Player(15, "Sam", 80);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(RuntimeException.class, () -> game.round("Pol", "Sam"));
    }

    @Test
    public void shouldThrowExceptionWhenSecondPlayerIsNotRegister() {
        Game game = new Game();
        Player player1 = new Player(12, "Will", 80);
        Player player2 = new Player(15, "Sam", 80);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(RuntimeException.class, () -> game.round("Will", "Pol"));
    }
}