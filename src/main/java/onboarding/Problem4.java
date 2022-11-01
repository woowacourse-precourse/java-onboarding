package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        /* ASCII 코드를 활용해 소문자, 대문자 알파벳을 반대로 변환*/
        List<Character> characters = word.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        characters = reverseUpperCase(characters);  // 대문자 알파벳 반대로 변환
        characters = reverseLowerCase(characters);  // 소문자 알파벳 반대로 변환
        String answer = characters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        ;  // 문자열 String으로 변환
        return answer;
    }

    static List<Character> reverseUpperCase(List<Character> characters) {
        characters.replaceAll(c -> (int) c >= 65 && (int) c <= 90 ? (char) (90 + 65 - (int) c) : c);
        return characters;
    }

    static List<Character> reverseLowerCase(List<Character> characters) {
        characters.replaceAll(c -> (int) c >= 97 && (int) c <= 122 ? (char) (122 + 97 - (int) c) : c);
        return characters;
    }
}