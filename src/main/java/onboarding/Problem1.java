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
    private static int getPlusScore(List<Integer> splitNumber) {
        return splitNumber.stream().mapToInt(i -> i).sum();
    }
    private static int getMultiplyScore(List<Integer> splitNumber) {
        return splitNumber.stream().reduce(1, (a, b) -> a * b);
    }
    private static int getMaxScore(int pageNumber) {
        List<Integer> splitNumber = splitDigitNumber(pageNumber);
        return Math.max(getPlusScore(splitNumber), getMultiplyScore(splitNumber));
    }
}