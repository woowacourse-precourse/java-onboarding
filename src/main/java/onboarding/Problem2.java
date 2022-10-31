package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        List<Character> code = new ArrayList<>();
        code = convert(cryptogram);

        return answer;
    }

    //문자열을 알파벳 리스트로 변환 함수
    static List<Character> convert(String string) {
        List<Character> chars = IntStream.range(0, string.length())
                .mapToObj(string::charAt)
                .collect(Collectors.toList());

        return chars;
    }
}
