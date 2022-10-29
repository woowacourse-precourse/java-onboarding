package onboarding;

import static java.lang.Integer.max;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int getPageMaxPoint(int page) {

        List<Integer> digits = getDigits(page);

        int maxSum = getMaxSum(digits);

        int cand2 = 1;
        for(int digit: digits)
            cand2 *= digit;

        return max(maxSum,cand2);
    }

    private static int getMaxSum(List<Integer> digits) {
        int ret = 0;
        for(int digit: digits)
            ret += digit;
        return ret;
    }

    private static List<Integer> getDigits(int page) {
        List<Integer> digits = new ArrayList<>();

        while(page > 0) {
            digits.add(page % 10);
            page /= 10;
        }

        return digits;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}