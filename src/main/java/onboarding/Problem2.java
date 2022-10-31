package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> cryptogramStack = deleteDuplicate(cryptogram);
        return stackToString(cryptogramStack);
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
    public static String stackToString(Stack<Character> cryptogramStack){
        return cryptogramStack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
