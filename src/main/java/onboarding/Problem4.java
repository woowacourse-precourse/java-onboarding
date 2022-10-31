package onboarding;

/*
기능 목록
1. 기능 요구 사항대로 문자를 뒤집는 기능
2. answer에 뒤집힌 문자들을 추가하는 기능
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        //answer에 뒤집힌 문자들을 추가
        for (char c : word.toCharArray()) {
            answer += reverse(c);
        }
        return answer;
    }

    //문자를 뒤집어서 반환하는 함수
    public static Character reverse(char c) {
        if (!Character.isAlphabetic(c)) {
            return c;
        } else if (Character.isLowerCase(c)) {
            return (char) ('a' + 'z' - c);
        } else {
            return (char) ('A' + 'Z' - c);
        }
    }
}