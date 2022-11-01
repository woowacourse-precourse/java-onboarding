package onboarding;

import java.security.spec.RSAOtherPrimeInfo;

public class Problem4 {
    // 2. word를 청개구리 언어로 바꾼다.
    public static String solution(String word) {
        String answer = "";
        int N = word.length();
        for(int i = 0; i < N; i++){
            char ch = word.charAt(i);
            answer += changeChar(ch);
        }
        return answer;
    }
    // 1. 청개구리 사전에 따라 문자를 return 해준다.
    public static char changeChar(char ch){
        if('a' <= ch && 'z' >= ch){
            return (char) ('a' + (25 - (ch - 'a')));
        }
        else if('A' <= ch && 'Z' >= ch) {
            return (char) ('A' + (25 - (ch - 'A')));
        }
        else{
            return ch;
        }
    }
}
