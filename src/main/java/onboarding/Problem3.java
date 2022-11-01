package onboarding;

public class Problem3 {
    public static int solution(int maxNumber) {
        int clapCnt = 0;

        for (int num = 1; num <= maxNumber; num++) {
            clapCnt += countClap(num);
        }

        return clapCnt;
    }

    private static int countClap(int num) {
        int clapCnt = 0;
        int digit;

        while (num != 0) {
            digit = num % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                clapCnt++;
            }
            num /= 10;
        }

        return clapCnt;
    }
}
