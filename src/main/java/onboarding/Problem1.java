package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
    private static List<Integer> splitDigitNumber(int pageNumber) {
        List<Integer> splitNumber = new ArrayList<>();
        while (pageNumber > 0) {
            splitNumber.add(pageNumber % 10);
            pageNumber /= 10;
        }
        return splitNumber;
    }
}