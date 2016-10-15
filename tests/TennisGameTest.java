
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TennisGameTest {

    TennisGame game = new TennisGame();

    @Test
    public void shouldReturnLove(){
        assertEquals ("Love equals", game.getScore());
    }

    @Test
    public void shouldReturnPlayerOneFifteen(){
        game.playerOneScores();

        assertEquals("Fifteen - Love", game.getScore());
    }

    @Test
    public void shouldReturnFifteenEquals(){
        game.playerOneScores();
        game.playerTwoScores();

        assertEquals("Fifteen equals", game.getScore());
    }

    @Test
    public void shouldReturnPlayerOneWins(){
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();

        assertEquals("Player ONE wins", game.getScore());
    }

    @Test
    public void shouldReturnDeuce(){
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();
        game.playerTwoScores();
        game.playerTwoScores();
        game.playerTwoScores();

        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void shouldReturnPlayerOneAdvantage(){
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();
        game.playerTwoScores();
        game.playerTwoScores();
        game.playerTwoScores();

        game.playerOneScores();

        assertEquals("Advantage: Player ONE", game.getScore());
    }

    @Test
    public void shouldReturnPlayerOneWinsAfterAdvantage(){
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();
        game.playerTwoScores();
        game.playerTwoScores();
        game.playerTwoScores();

        game.playerOneScores();
        game.playerOneScores();

        assertEquals("Player ONE wins", game.getScore());
    }

    @Test
    public void shouldReturnDeuceAfterMultipleRounds(){
        game.playerOneScores();
        game.playerOneScores();
        game.playerOneScores();
        game.playerTwoScores();
        game.playerTwoScores();
        game.playerTwoScores();

        game.playerOneScores();
        game.playerTwoScores();

        game.playerOneScores();
        game.playerTwoScores();

        game.playerOneScores();
        game.playerTwoScores();

        assertEquals("Deuce", game.getScore());
    }



}
