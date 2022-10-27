package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = reverseAlphabetic(word);
        return answer;
    }

    private static String reverseAlphabetic(String word) {
        StringBuilder sb = new StringBuilder();
        word.chars()
                .mapToObj(i -> (char) i)
                .forEach(c -> {
                    if (isUppercase(c))
                        sb.append((char) ('Z' + 'A' - c));
                    else if (isLowercase(c))
                        sb.append((char) ('z' + 'a' - c));
                    else
                        sb.append(c);
                });
        return sb.toString();
    }

    private static boolean isUppercase(char c) {
        return 65 <= c && c <= 90;
    }

    private static boolean isLowercase(char c) {
        return 97 <= c && c <= 122;
    }
}
/*
문제 설명
  1. 알파벳 순서를 바꾼다. A -> Z 를 Z -> A 순서로 바꿈

문제 예시
  1. "I love you" => "R olev blf"

제한사항 및 주의할점
  - word는 길이가 1 이상 1,000 이하 문자열
  - 알파벳 외의 문자는 변환하지 않음 (알파벳 범위 지정해야함)
  - 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환
  - 'A' ~ 'Z' 는 65 ~ 90
  - 'a' ~ 'z' 는 97 ~ 122
 */