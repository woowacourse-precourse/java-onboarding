package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = count(number);
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

    public static int count(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += clap(i);
        }
        return sum;
    }
}
