package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer="answer";
        if(checkout(cryptogram)) answer =removeDuplicate(cryptogram);
        return answer;
    }

    public static boolean checkout(String cryptogram){
        String input = "cryptogram";
        if (input.matches("^[a-z]*$"))
            return true;
        return false;
    }

    public static String removeDuplicate(String s) {
        int result = 0;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        int n = stack.size();
        char word[] = new char[n];
        while(!stack.empty()){
            word[--n] = stack.pop();
        }
        return String.copyValueOf(word);
    }
}