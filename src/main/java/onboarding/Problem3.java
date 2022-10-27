package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int clap(int number) {
        int clapCount = 0;
        String[] digits = String.valueOf(number).split("");

        for (String digit : digits) {
            if (digit.equals("3") || digit.equals("6") || digit.equals("9")) {
                clapCount++;
            }
        }
        return clapCount;
    }
}
