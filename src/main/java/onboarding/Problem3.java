package onboarding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem3 {

    private static final String[] List369 = {"3", "6", "9"};

    public static int solution(int number) {
        return (int) IntStream.rangeClosed(1, number)
                .mapToObj(Integer::toString)
                .flatMap(data -> Arrays.stream(data.split("")))
                .filter(s-> Arrays.stream(List369).anyMatch(s::equals)).count();

    }
}