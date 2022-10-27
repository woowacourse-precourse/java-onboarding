package onboarding;

import java.util.ArrayList;
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
}