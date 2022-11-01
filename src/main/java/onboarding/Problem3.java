package onboarding;

public class Problem3 {
    public static int solution(int number) {
        validate(number);
        return playGame(number);
    }

    private static void validate(int number) {
        if (number < 1 || number > 10000) {
            throw new IllegalArgumentException("number는 1 이상 10,000 이하인 자연수이어야 합니다.");
        }
    }

    private static int playGame(int number) {
        int clapCount = 0;
        for (int turn = 1; turn <= number; turn++) {
            clapCount = playTurn(clapCount, turn);
        }
        return clapCount;
    }

    private static int playTurn(int clapCount, int speakNumber) {
        while (speakNumber > 0) {
            clapCount = addClapNumber(clapCount, speakNumber % 10);
            speakNumber = speakNumber / 10;
        }
        return clapCount;
    }

    private static int addClapNumber(int clapCount, int number) {
        if (isClapCondition(number)) {
            clapCount++;
        }
        return clapCount;
    }

    private static boolean isClapCondition(int number) {
        return number == 3 || number == 6 || number == 9;
    }
}
