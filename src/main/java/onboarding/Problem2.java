package onboarding;


import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        if(validateCheck(cryptogram)) {
            Stack<Character> tmp = duplicateString(cryptogram);
            answer = findAnswer(tmp);
        }
        else {
            answer = "";
        }
        return answer;
    }

    private static boolean validateCheck(String num){
        int length = num.length();
        boolean status = lowerAlphaCheck(num);
        if(length < 1 || length > 1000){
            return false;
        }
        else if(status){
            return false;
        }
        else {
            return true;
        }
    }
    private static boolean lowerAlphaCheck(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) < 'a' || s.charAt(i) > 'z'){
                return true;
            }
        }
        return false;
    }
    private static Stack duplicateString(String s) {
        Stack<Character> stack = new Stack<>();
        String tmp = "";
        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(stack.peek() == s.charAt(i)){
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        return stack;
    }
    private static String findAnswer(Stack<Character> stack){
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}
