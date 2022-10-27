package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        List<Integer> separateList = separateToNumber(number);
        return (int)get369Count(separateList);

    }
    private static List<Integer> separateToNumber(int number) {
        List<Integer> separate = new ArrayList<>();
        while (number > 0) {
            separate.add(number % 10);
            number = number / 10;
        }
        return separate;
    }
    private static long get369Count(List<Integer> separateList) {
        return separateList.stream()
                    .filter(Problem3::is369)
                    .count();
    }
    private static boolean is369(Integer integer) {
        return List.of(3, 6, 9)
                   .contains(integer);
    }
}
