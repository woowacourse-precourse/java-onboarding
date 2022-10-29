package onboarding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem3 {
    private static final Set<String> clapNumbers = new HashSet<>(List.of("3", "6", "9"));
    private static final String SPACE = "";

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int claps(int number) {
        return Arrays.stream(String.valueOf(number).split(SPACE))
                .filter(clapNumbers::contains)
                .collect(Collectors.toList())
                .size();
    }
}
