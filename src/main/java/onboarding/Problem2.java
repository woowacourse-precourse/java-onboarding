package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    // 암호문 배열로 분리
    private static List<String> splitCryptogram(String cryptogram) {
        return Arrays.stream(cryptogram.split("")).collect(Collectors.toList());
    }


}
