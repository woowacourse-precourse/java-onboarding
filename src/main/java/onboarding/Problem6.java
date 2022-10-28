package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem6 {

    private static final int TWO = 2;

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<String> computeTwoLetter(String input) {
        List<String> twoLetter = new ArrayList<>();

        IntStream.range(0, input.length() - TWO)
            .forEach(i -> twoLetter.add(input.substring(i, i + TWO)));
        return twoLetter;
    }
}
