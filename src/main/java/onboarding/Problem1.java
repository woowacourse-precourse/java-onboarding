package onboarding;

import static java.lang.Integer.max;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int getPageMaxPoint(int page) {

        List<Integer> digits = getDigits(page);

        int cand1 = 0;
        for(int digit: digits)
            cand1 += digit;

        int cand2 = 1;
        for(int digit: digits)
            cand2 *= digit;

        return max(cand1,cand2);
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