package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        return answer;
    }
    public static Stack<Character> deleteDuplicate(String cryptogram){
        Stack<Character> cryptogramStack = new Stack<>();
        char[] cryptogramCharArray = cryptogram.toCharArray();
        for (int i = 0; i < cryptogramCharArray.length; i++) {
            if(!cryptogramStack.empty() && cryptogramStack.peek().equals(cryptogramCharArray[i])){
                cryptogramStack.pop();
            }
            else {
                cryptogramStack.push(cryptogramCharArray[i]);
            }
        }
        return cryptogramStack;
    }
}
