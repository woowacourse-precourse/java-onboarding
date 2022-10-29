package onboarding;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Problem3 {

    static final int START_RANGE = 1;
    static final int END_RANGE = 10_000;

    private static boolean isValidNumber(int num) {
        return START_RANGE <= num && num <= END_RANGE;
    }
    public static boolean isClapCase(int oneDigitNum) {
        int[] clapCases = {3, 6, 9};

        for (int clapCase : clapCases) {
            if (oneDigitNum == clapCase) {
                return true;
            }
        }

        return false;
    }

    private static List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<>();

        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }

        return digits;
    }

    public static int getClapCount(int num) {
        int ret = 0;

        List<Integer> digits = getDigits(num);

        for (int digit : digits) {
            if (isClapCase(digit)) {
                ++ret;
            }
        }

        return ret;
    }

    public static int getClapCountSum(int maxNum) {
        if (!isValidNumber(maxNum)) {
            throw new InputMismatchException("입력 범위가 [1, 10_000] 안에 있지 않습니다.");
        }

        int ret = 0;

        for (int clapNum = 1; clapNum <= maxNum; ++clapNum) {
            ret += getClapCount(clapNum);
        }

        return ret;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
