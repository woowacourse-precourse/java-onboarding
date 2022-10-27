package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    private static final char ZERO = '0';

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    public static List<Integer> getEachDigit(Integer page) {
        List<Integer> digits = new ArrayList<>();
        String pageString = page.toString();

        for (int i = 0; i < pageString.length(); i++) {
            digits.add(pageString.charAt(i) - ZERO);
        }

        return digits;
    }

    public static Integer plusEachDigit(List<Integer> digits) {
        Integer sum = 0;
        for (Integer digit : digits) {
            sum += digit;
        }

        return sum;
    }

    public static Integer multiplyEachDigit(List<Integer> digits) {
        Integer sum = 1;
        for (Integer digit : digits) {
            sum *= digit;
        }

        return sum;
    }

    public static Integer getMax(List<Integer> num) {
        return Collections.max(num);
    }
}