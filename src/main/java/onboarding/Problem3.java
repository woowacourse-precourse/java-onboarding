package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    static int splitSingleDigit(String numbers) {
        int targetNumberCount = 0;

        for (char charOfNumber : numbers.toCharArray()) {
            targetNumberCount += checkTargetNumber(charOfNumber);
        }

        return targetNumberCount;
    }

    static int checkTargetNumber(char charOfNumber) {
        if (charOfNumber == '3') {
            return 1;
        }

        if (charOfNumber == '6') {
            return 1;
        }

        if (charOfNumber == '9') {
            return 1;
        }

        return 0;
    }
}
