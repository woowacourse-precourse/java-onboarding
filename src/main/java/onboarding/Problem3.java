package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countTargetNumber(i);
        }

        return answer;
    }

    public static long countTargetNumber(int number) {
        String[] splitNumber = Integer.toString(number).split("");

        return Arrays.stream(splitNumber).filter(eachNumber ->
                eachNumber.equals("3") || eachNumber.equals("6") || eachNumber.equals("9")
        ).count();
    }
}
