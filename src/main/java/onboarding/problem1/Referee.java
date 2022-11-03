package onboarding.problem1;

public class Referee {
    private Pages pobi;
    private Pages crong;

    public Referee(Pages pobi, Pages crong) {
        this.pobi = pobi;
        this.crong = crong;
    }

    public int getMatchResult() {
        if (pobi.getMaxScore() > crong.getMaxScore()) {
            return 1;
        }

        if (crong.getMaxScore() > pobi.getMaxScore()) {
            return 2;
        }

        return 0;
    }
}
