package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        GameData pobiData = new GameData(pobi);
        GameData crongData = new GameData(crong);

        answer = PageNumberGame.PlayGame(pobiData,crongData);

        return answer;
    }
}

class GameData {
    private List<Integer> gameData;

    GameData(List<Integer> gameData) {
        this.gameData = gameData;
    }

    private boolean verifyGameData() {

        if(gameData.size() > 2 ){
            return false;
        }

        if((gameData.get(0) % 2) != 1) {
            return false;
        }

        if((gameData.get(1) - gameData.get(0)) != 1) {
            return false;
        }

        return true;
    }

    public boolean isValid() {
        return verifyGameData();
    }

    public int calculateScore() {
        int leftPageNumber = gameData.get(0);
        int rightPageNumber = gameData.get(1);

        int[] arrayForLeft = divideEachDigit(leftPageNumber);
        int[] arrayForRight = divideEachDigit(rightPageNumber);

        int leftScore = getBiggerScore(
                addEachDigit(arrayForLeft),multiplyEachDigit(arrayForLeft));
        int rightScore = getBiggerScore(
                addEachDigit(arrayForRight),multiplyEachDigit(arrayForRight));

        return getBiggerScore(leftScore,rightScore);
    }

    public int getBiggerScore(int ScoreA, int ScoreB) {
        if (ScoreA > ScoreB) {
            return ScoreA;
        }
        return ScoreB;
    }

    private int[] divideEachDigit(int number) {
        int n = number;
        int digit = (int)Math.log10(n) + 1;
        int[] arrayEachDigit = new int[digit];

        for (int i = 0; i < digit; i++) {
            arrayEachDigit[i] = (n % 10);
            n /= 10;
        }
        return arrayEachDigit;
    }

    private int addEachDigit(int[] arrayEachDigit) {
        int dst = 0;
        for (int a : arrayEachDigit) {
            dst += a;
        }
        return dst;
    }

    private int multiplyEachDigit(int[] arrayEachDigit) {
        int dst = 1;
        for (int a : arrayEachDigit) {
            dst *= a;
        }
        return dst;
    }
}
final class GameResult {
    public static final int DATA_ERR = -1;
    public static final int DRAW = 0;
    public static final int WINNER_POBI = 1;
    public static final int WINNER_CRONG = 2;
}

class PageNumberGame {

    public static int PlayGame(GameData playerOne, GameData playerTwo) {

        if(!(playerOne.isValid() && playerTwo.isValid())) {
            return GameResult.DATA_ERR;
        }

        int playerOneScore = playerOne.calculateScore();
        int playerTwoScore = playerTwo.calculateScore();

        if(playerOneScore > playerTwoScore) {
            return GameResult.WINNER_POBI;
        }

        if(playerOneScore < playerTwoScore) {
            return GameResult.WINNER_CRONG;
        }

        return GameResult.DRAW;

    }
}