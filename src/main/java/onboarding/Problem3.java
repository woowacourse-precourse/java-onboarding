package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += addClapTimes(i);
        }

        return answer;
    }

    private static int isClapNumber(int unitNumber) {
        if ((unitNumber % 3 == 0) && (unitNumber != 0)) {
            return 1;
        }
        return 0;
    }

    private static int addClapTimes(int testNumber) {
        int clapTimes = 0;

        while (testNumber > 0) {
            int unitNumber = testNumber % 10;
            clapTimes += isClapNumber(unitNumber);
            testNumber /= 10;
        }

        return clapTimes;
    }
}