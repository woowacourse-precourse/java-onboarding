package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int length = cryptogram.length();
        // 제한 사항 1 - cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
        if (length < 1 || length > 1000) {
            answer = "cryptogram의 길이가 이상합니다.";
            return answer;
        }
        // stack을 이용해서 삭제
        char[] character = cryptogram.toCharArray();
        // 제한 사항 2 - cryptogram은 알파벳 소문자로만 이루어져 있다.
        for(char x : character){
            if (!Character.isLowerCase(x)) {
                answer = "cryptogram이 소문자가 아닙니다.";
                return answer;
            }

        }
        Stack<Character> temp = new Stack<>();
        for(int i=0; i < character.length; i++) {
            char x = character[i];
            if (temp.isEmpty()) temp.push(x);
            else {
                if (temp.peek() == x) {
                    temp.pop();
                    while(i+1 != character.length && x == character[i+1]){
                        i += 1;
                    }
                }
                else temp.push(x);
            }
        }

        for(char x : temp){
            answer += x;
        }
        return answer;
    }
}
