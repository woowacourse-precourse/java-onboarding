package onboarding.problem3;

public class ClapGame {
    private final GameNumber gameNumber;

    public ClapGame(GameNumber gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getClapCount() {
        return gameNumber.getRange().reduce(0, (total, number) -> total + getClapCountWithNumber(number));
    }

    private int getClapCountWithNumber(int currentNumber) {
        return new ClapCounter(currentNumber).getClapCount();
    }
}
