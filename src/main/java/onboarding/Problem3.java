package onboarding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return (int) IntStream.rangeClosed(1, number)
                .mapToObj(String::valueOf)
                .map(stringNumber -> stringNumber.split(""))
                .flatMap(numberArray -> Arrays.stream(numberArray)
                        .filter(letter -> letter.equals("3") || letter.equals("6") || letter.equals("9")))
                .count();
    }
}
