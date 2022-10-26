package problem1;

import java.util.List;

public class Referee {

    private final Player pobi;
    private final Player crong;

    public Referee(List<Integer> pobi, List<Integer> crong) {
        this.pobi = new Player(pobi);
        this.crong = new Player(crong);
    }

    public GameResultStatus playGame() {
        int pobiScore = pobi.calculateTotalScore();
        int crongScore = crong.calculateTotalScore();

        return playGame(pobiScore, crongScore);
    }

    private GameResultStatus playGame(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return GameResultStatus.POBI_WIN;
        }
        if (crongScore > pobiScore) {
            return GameResultStatus.CRONG_WIN;
        }
        return GameResultStatus.DRAW;
    }
}
