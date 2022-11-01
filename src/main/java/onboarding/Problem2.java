package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>();
        String[] str = cryptogram.split("");
        StringBuilder sb = new StringBuilder();

        stack.push(str[0]);
            for(int i = 1; i<sb.length(); i++){
                if((stack.peek()).equals(String.valueOf(sb.charAt(i)))==false){
                    stack.push(String.valueOf(sb.charAt(i)));
                    System.out.println("push : " + stack.peek());
                }else if((stack.peek()).equals(String.valueOf(sb.charAt(i)))){
                    System.out.println("pop : " + stack.peek());
                    stack.pop();
                }
            }

        String answer = "answer";
        return answer;
    }
}
