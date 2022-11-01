package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>();
        String[] str = cryptogram.split("");
        StringBuilder sb = new StringBuilder();

        // 중복 문자 pop, 중복 아닌 문자 push
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

        // 스택에 쌓은 문자를 문자열로 변환 하여 return
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < stack.size(); i++){
            ans.append(stack.get(i));
        }
        String answer = ans.toString();
        return answer;
    }
}
