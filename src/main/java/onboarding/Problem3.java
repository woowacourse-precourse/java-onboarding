package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return IntStream.rangeClosed(1, number)
                        .map(Problem3::get369Count)
                        .sum();
    }
    private static List<Integer> separateToNumber(int number) {
        List<Integer> separate = new ArrayList<>();
        while (number > 0) {
            separate.add(number % 10);
            number = number / 10;
        }
        return separate;
    }
    private static int get369Count(int number) {
        List<Integer> separate = separateToNumber(number);
        return (int)separate.stream()
                    .filter(Problem3::is369)
                    .count();
    }
    private static boolean is369(Integer integer) {
        return List.of(3, 6, 9)
                   .contains(integer);
    }
}
