package problem1;

import java.util.List;

public class Referee {

    private final Player pobi;
    private final Player crong;

    public Referee(List<Integer> pobi, List<Integer> crong) {
        this.pobi = new Player(pobi);
        this.crong = new Player(crong);
    }

    public int playGame() {
        int pobiScore = pobi.calculateTotalScore();
        int crongScore = crong.calculateTotalScore();

        if (pobiScore > crongScore) {
            return 1;
        }
        if (crongScore > pobiScore) {
            return 2;
        }
        if (crongScore == pobiScore) {
            return 0;
        }
        return -1;
    }
}
