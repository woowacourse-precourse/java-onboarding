package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem3 {
    public static List<Integer> splitNumber(int number){
        return Stream.of(String.valueOf(number).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
