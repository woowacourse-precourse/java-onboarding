package onboarding.problem3;

public class ClapGame {
    private final GameNumber gameNumber;

    public ClapGame(GameNumber gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getClapCount() {
        return gameNumber.getRange().reduce(0, this::getClapCountWithNumber);
    }

    private int getClapCountWithNumber(int total, int number) {
        return total + new ClapCounter(number).getClapCount();
    }
}
