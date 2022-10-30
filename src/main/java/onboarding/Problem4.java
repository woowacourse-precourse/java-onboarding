package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        //문자열을 띄어쓰기 포함 알파벳 리스트로 변환
        List<Character> wordCharList = new ArrayList<>();
        wordCharList=convert(word);

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
