package onboarding;

import java.util.List;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        char[][] arr = Stream.of(forms).map(String::toCharArray).toArray(Object[]::new);

        return answer;
    }
}
