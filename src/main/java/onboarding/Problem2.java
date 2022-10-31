package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static boolean checkDuplicated(String cryptogram){
        for(int i = 0; i < cryptogram.length()-1; i++){
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
    public static Stack<Character> removeDuplicate(String cryptogram){
        Stack<Character> stack = new Stack<>();

        stack.push(cryptogram.charAt(0));
        for(int i = 1; i < cryptogram.length(); i++){
            if(cryptogram.charAt(i-1) != cryptogram.charAt(i)){
                stack.push(cryptogram.charAt(i));
            }else{
                if(stack.peek() == cryptogram.charAt(i)){
                    stack.pop();
                }
            }
        }
        return stack;
    }

    public static String reverse(String result){
        StringBuffer sb = new StringBuffer(result);
        result = sb.reverse().toString();
        return result;
    }
}
