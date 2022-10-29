package onboarding;
import java.util.*;
import java.io.*;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String removeDuplication(String input){
        Stack<Character> stack = new Stack<>();
        stack.add('0');

        boolean duple = false;
        for(char c : input.toCharArray()){
            if(c==stack.peek()) duple = true; // 같은 문자 checking
            else{
                if(duple){
                    stack.pop();
                    duple = false;
                }
                stack.push(c);
            }
        }

        if(duple) stack.pop();
        StringBuffer sb = new StringBuffer();
        for(char c : stack){
            sb.append(c);
        }
        return sb.toString().substring(1);
    }
}
