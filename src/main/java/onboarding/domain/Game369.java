package onboarding.domain;

public class Game369 {
    private final int gameResult;

    public Game369(int number) {
        gameResult = playGame(number);
    }

    private int playGame(int number) {
        int count = 0;
        for (int i = 3; i <= number; i++) {
            count += howManyClap(i);
        }
        return count;
    }

    private static int howManyClap(int currentNumber) {
        int clapCount = 0;
        while (currentNumber != 0) {
            clapCount += canClap(currentNumber);
            currentNumber /= 10;
        }
        return clapCount;
    }

    private static int canClap(int currentNumber) {
        if (isClapNumber(currentNumber)) {
            return 1;
        }
        return 0;
    }

    private static boolean isClapNumber(int currentNumber) {
        return currentNumber % 10 == 3 || currentNumber % 10 == 6 || currentNumber % 10 == 9;
    }

    public int getGameResult() {
        return gameResult;
    }
}
