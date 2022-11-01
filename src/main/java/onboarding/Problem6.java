package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();



        // result로 오름차순 정렬되게 stream 구현
        return answer.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

}
