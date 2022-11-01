package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeSameChar(cryptogram);
    }

    private static String removeSameChar(String string) {
        // 연속하는 중복 문자들을 삭제하는 메소드
        Stack<String> stack = new Stack<>();

        for (String s : string.split("")) {
            if(!stack.isEmpty() && stack.peek().equals(s)){
                stack.pop();
            }
            else{
                stack.push(s);
            }
        }
        return String.join("",stack);
    }
}
