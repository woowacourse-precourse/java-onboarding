package onboarding;

import java.util.stream.Stream;

/*
 *  구현 기능
 *  1. 문자열을 각 토큰으로 분할하는 기능
 *  2. 알파벳을 대응하는 뒤집힌 알파벳으로 변환하는 기능
 *  3. 뒤집힌 알바벳을 다시 문장으로 만들어 봔환하는 기능
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

class AlphaSwaper {
    private Stream token;
    public AlphaSwaper(Stream token){
        this.token = token;
    }


    public char converseAlpha(char alpha) {
        if(!Character.isAlphabetic(alpha)) {
            return alpha;
        }
        if(Character.isUpperCase(alpha)) {
            return (char) ('Z' - alpha + 'A');
        }
        else {
            return (char) ('z' - alpha + 'a');
        }
    }

}