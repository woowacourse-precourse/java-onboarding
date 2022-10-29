package onboarding;

public class Problem3 {
    private static final int[] GAME_NUMBERS = {3, 6, 9};

    public static int solution(int number) {
        int answer = 0;
        while (number > 0) {
            answer += getMatchedGameNumberCount(number);
            number--;
        }
        return answer;
    }

    private static int getMatchedGameNumberCount(int number) {
        int matchedDigits = 0;
        while (number > 0) {
            matchedDigits += getMatchedDigitCount(number % 10);
            number = number / 10;
        }
        return matchedDigits;
    }

    private static int getMatchedDigitCount(int digit) {
        int match = 0;
        for (int gameNumber : GAME_NUMBERS) {
            match += isMatched(digit, gameNumber);
        }
        return match;
    }

    private static int isMatched(int digit, int gameNumber) {
        if (digit == gameNumber) {
            return 1;
        }
        return 0;
    }
}
