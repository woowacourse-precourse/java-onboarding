package onboarding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return (int) IntStream.rangeClosed(1, number)
                .mapToObj(String::valueOf)
                .map(i -> i.split(""))
                .flatMap(j -> Arrays.stream(j).filter(k -> k.equals("3") || k.equals("6") || k.equals("9")))
                .count();
    }
}
