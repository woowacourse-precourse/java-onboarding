package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            char[] numCharArr = Integer.toString(i).toCharArray();
            for (char num : numCharArr) {
                if (num == '3' || num == '6' || num == '9') {
                    answer++;
                }
            }
        }
        List<char[]> charArr = IntStream.range(1, number + 1)
                .mapToObj(num -> Integer.toString(num).toCharArray())
                .collect(Collectors.toList());
        return answer;
    }
}
