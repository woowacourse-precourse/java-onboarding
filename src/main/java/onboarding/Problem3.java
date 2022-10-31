package onboarding;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
* 1. 수를 파라미터로 받아 3, 6, 9의 개수를 세어 반환하는 함수 추가
*   1-1. 수를 각 자리 숫자로 분리하여 3, 6, 9의 개수를 센다
* 2. 메인로직에서는 수를 함수에 map 하여 누적합을 구하는 로직을 추가
*/

public class Problem3 {
    public static int solution(int number) {
        return IntStream.rangeClosed(1, number)
                .map(Problem3::countThreeAndSixAndNine)
                .sum();
    }

    private static int countThreeAndSixAndNine(int number) {
        return (int) Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .filter(n -> n == 3 || n == 6 || n == 9)
                .count();
    }
}
