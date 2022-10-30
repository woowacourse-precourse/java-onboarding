package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> stack = new Stack<>();

        deleteDuplicated(stack,cryptogram);
        answer = makeToString(stack);
        return answer;
    }
    public static void deleteDuplicated( Stack<Character> stack,String cryptogram){

         for (int len = cryptogram.length(),i=0;i<len;i++){
             if (!stack.isEmpty()&&stack.peek() == cryptogram.charAt(i)){
                 stack.pop();
             }else{
                 stack.push(cryptogram.charAt(i));
             }
         }

    }
    public static String makeToString(Stack<Character> stack){
        StringBuilder sb = new StringBuilder();

        for (char c : stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
