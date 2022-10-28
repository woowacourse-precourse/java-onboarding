package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        pobi.stream().forEach((page) -> {
            System.out.println(sumOfEachNum(page));
            System.out.println(multiplyOfEachNum(page));
        });

        return answer;
    }

    private static Integer sumOfEachNum(Integer num) {
        return toDigitStream(num).reduce(0, Integer::sum);
    }

    private static Integer multiplyOfEachNum(Integer num) {
        return toDigitStream(num).reduce(1, (prev, curr) -> prev * curr);
    }

    private static Stream<Integer> toDigitStream(Integer num) {
        return Arrays.stream(num.toString()
                .split("")).map(Integer::parseInt);
    }
}