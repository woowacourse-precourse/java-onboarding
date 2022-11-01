package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {

    private static List<String> tokenizer(String str) {
        return IntStream.rangeClosed(0, str.length() - 2)
            .mapToObj(i -> String.join("", Arrays.copyOfRange(str.split(""), i, i + 2)))
            .collect(Collectors.toList());
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
