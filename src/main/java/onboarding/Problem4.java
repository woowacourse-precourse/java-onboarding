package onboarding;

import java.util.stream.Stream;

/*
 *  구현 기능
 *  1. 문자열을 각 토큰으로 분할하는 기능
 *  2. 각 토큰이 알파벳인지 검사하는 기능
 *  3. 알파벳을 대응하는 뒤집힌 알파벳으로 변환하는 기능
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

class StringTokenizer {
    private Stream wordToken;

    public StringTokenizer(String word) {
        this.wordToken = word.chars().mapToObj(a -> (char)a);
    }

    public Stream getToken(){
        return wordToken;
    }
}

