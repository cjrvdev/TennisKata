/**
 * Created by Tronx on 15/10/2016.
 */
public class TennisGame {

    int playerOneScore;
    int playerTwoScore;
    String playerOneName;
    String playerTwoName;


    public TennisGame() {
        playerOneScore = 0;
        playerTwoScore = 0;
        playerOneName = "Player ONE";
        playerTwoName = "Player TWO";
    }

    public String getScore(){

        if (hasWinner()){
            return playerWithHighestScore() + " wins";
        }

        if (isAdvantage()){
            return "Advantage: " + playerWithHighestScore();
        }

        if (isDeuce()){
            return "Deuce";
        }

        if(isEquals()){
            return formatScore(playerOneScore) + " equals";
        }

        return formatScore(playerOneScore) + " - " + formatScore(playerTwoScore);
    }

    private boolean isEquals() {
        if (playerOneScore == playerTwoScore)
            return true;

        return false;
    }

    private boolean hasWinner() {
        if (playerOneScore >= playerTwoScore + 2 && playerOneScore >= 4)
            return true;
        else if (playerTwoScore >= playerOneScore + 2 && playerTwoScore >= 4)
            return true;

        return false;
    }

    private boolean isAdvantage() {
        if (playerOneScore >= playerTwoScore + 1 && playerOneScore >= 3)
            return true;
        else if (playerTwoScore >= playerOneScore + 1 && playerTwoScore >= 3)
            return true;

        return false;
    }

    private boolean isDeuce() {
        if (playerOneScore >= 3 && playerTwoScore >= 3 && playerOneScore == playerTwoScore)
            return true;

        return false;
    }

    private String formatScore(int score) {
        switch(score){

            case 0 :
                return "Love";

            case 1 :
                return "Fifteen";

            case 2 :
                return "Thirty";

            case 3 :
                return "Forty";

            default : return "Illegal Score";
        }
    }

    private String playerWithHighestScore() {
        if (playerOneScore > playerTwoScore)
            return playerOneName;
        else
            return playerTwoName;
    }

    public void playerOneScores(){
        playerOneScore++;
    }

    public void playerTwoScores(){
        playerTwoScore++;
    }



}
