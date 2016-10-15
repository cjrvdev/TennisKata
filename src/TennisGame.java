/**
 * Created by Tronx on 15/10/2016.
 */

public class TennisGame {

    private int playerOneScore;
    private int playerTwoScore;
    private String playerOneName;
    private String playerTwoName;


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

        return formattedMatchScore(playerOneScore, playerTwoScore);
    }

    private boolean isEquals() {
        return playerOneScore == playerTwoScore;
    }

    private boolean hasWinner() {
        return (scoreDifference(playerOneScore, playerTwoScore) && matchIsWinnable());
    }

    private boolean matchIsWinnable() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private boolean scoreDifference(int firstScore, int secondScore) {
        return Math.abs(firstScore - secondScore) >= 2;
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

    private String formattedMatchScore(int playerOneScore, int playerTwoScore) {
        return formatScore(playerOneScore) + " - " + formatScore(playerTwoScore);
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
