
public class TennisGame1 implements TennisGame {

    private class Player {
        int score;
        String name;

        public Player(String name) {
            this.name = name;
            this.score = 0;
        }
    }

    private Player player1;
    private Player player2;

    private int player1Score = 0;
    private int player2Score = 0;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1.name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (player1Score == player2Score)
        {
            score = getEvenScore(player1Score);
        }
        else if (player1Score >=4 || player2Score >=4)
        {
            score = getAdvantageScore();
        }
        else
        {
            score = getOtherScore();
        }
        return score;
    }

    private String getOtherScore() {
        String score = "";
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = player1Score;
            else { score+="-"; tempScore = player2Score;}
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }

    private String getAdvantageScore() {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult==1) score ="Advantage " + this.player1.name;
        else if (minusResult ==-1) score ="Advantage " + this.player2.name;
        else if (minusResult>=2) score = "Win for " + this.player1.name;
        else score ="Win for " + this.player2.name;
        return score;
    }

    private String getEvenScore(int score) {
        switch (score)
        {
            case 0:
                return  "Love-All";
            case 1:
                return  "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
