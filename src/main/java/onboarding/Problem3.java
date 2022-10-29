package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        try {
            validation(number);

            int answer = count(number);
            return answer;
        } catch (RuntimeException e) {
            throw e;
        }

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

    public static void validation(int number) {
        if (number<1 || number > 10000) {
            throw new RuntimeException("숫자는 1 이상 10000 이하입니다.");
        }
    }
}
