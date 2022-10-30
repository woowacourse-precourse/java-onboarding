package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static final String REGEX = "[3|6|9]";

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int getClapCount(int number) {
        return (int)Stream.of(String.valueOf(number).split(""))
                .filter(num -> num.matches(REGEX))
                .count();
    }
}
