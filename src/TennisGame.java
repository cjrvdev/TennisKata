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
        return hasEnoughScoreDifference(playerOneScore, playerTwoScore, 2) && matchIsWinnable();
    }

    private boolean matchIsWinnable() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private boolean hasEnoughScoreDifference(int firstScore, int secondScore, int minimumDifference) {
        return Math.abs(firstScore - secondScore) >= minimumDifference;
    }

    private boolean isAdvantage() {
        return hasEnoughScoreDifference(playerOneScore, playerTwoScore, 1) &&
                ( playerCanGetAdvantage(playerOneScore) ||
                        playerCanGetAdvantage(playerTwoScore) ) ;
    }

    private boolean playerCanGetAdvantage(int playerScore) {
        return playerScore >= 3;
    }

    private boolean isDeuce() {
        return playerOneScore >= 3 && playerTwoScore >= 3 && playerOneScore == playerTwoScore;
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
