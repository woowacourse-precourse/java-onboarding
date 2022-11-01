package onboarding;

import java.util.Iterator;
import java.util.Stack;

public class Problem2 {

    public static String charArraytoString(Iterable<Character> target) {
        Iterator itr = target.iterator();
        String temp = "";
        while (itr.hasNext()) {
            temp += itr.next().toString();
        }
        return temp;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> stack = new Stack<Character>();
        
        int beforeLen, afterLen;
        
        while (true) {
            stack.clear();
            beforeLen = cryptogram.length();
            
            for (char ch : cryptogram.toCharArray()) {
                if (stack.isEmpty()){
                    stack.push(ch);
                }
                else {
                    if (stack.peek() != ch) {
                        stack.push(ch);
                    } else {
                        stack.pop();
                    }
                }
            }

            cryptogram = charArraytoString(stack);
            afterLen = cryptogram.length();
            
            if (beforeLen == afterLen) {
                answer = cryptogram;
                break;
            }
        }

        return answer;
    }
}