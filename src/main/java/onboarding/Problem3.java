package onboarding;

import java.util.Arrays;

public class Problem3 {
    private static final String THREE = "3";
    private static final String SIX = "6";
    private static final String NINE = "9";

    public static int solution(int number) {
        int answer = 0;

        for (int n = 1; n <= number; n++) {
            answer += countThreeSixNine(n);
        }

        return answer;
    }

    private static long countThreeSixNine(int n) {
        String[] str = Integer.toString(n).split("");

        return Arrays
                .stream(str)
                .filter(Problem3::isThreeSixNine)
                .count();
    }

    private static boolean isThreeSixNine(String s) {
        return s.equals(THREE) || s.equals(SIX) || s.equals(NINE);
    }
}
