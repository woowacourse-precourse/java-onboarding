package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static void deleteConsecutiveDuplicate(String cryptogram){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < cryptogram.length(); i++){
            if(!stack.isEmpty() && stack.peek()==cryptogram.charAt(i)){
                stack.pop();
                continue;
            }
            stack.push(cryptogram.charAt(i));
        }
        return;
    }
}
