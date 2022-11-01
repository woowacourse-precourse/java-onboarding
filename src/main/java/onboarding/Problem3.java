package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            answer += getClap(i);
        }

        return answer;
    }

    public static int getClap(int number) {
        return Arrays.asList(Integer.toString(number).split(""))
                .stream()
                .filter((v) -> v.equals("3") || v.equals("6") || v.equals("9")).toArray().length;
    }
}
