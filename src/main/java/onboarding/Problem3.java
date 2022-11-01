package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static final String RULE = "[3|6|9]";

    public static int solution(int number) {
        return getTotalClaps(number);
    }

    public static int getClapCount(int number) {
        return (int)Stream.of(String.valueOf(number).split(""))
                .filter(num -> num.matches(RULE))
                .count();
    }

    public static int getTotalClaps(int endNumber) {
        int total = 0;
        for(int number = 1; number <= endNumber; number++) {
            total += getClapCount(number);
        }
        return total;
    }
}
