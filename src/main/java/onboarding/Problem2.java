package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String removeDuplicateCharacters(String  cryptogram) {
        Stack<Character> cryptStack = new Stack<>();

        for(int i=0; i < cryptogram.length(); i++){
            if(!cryptStack.empty() && cryptogram.charAt(i) == cryptStack.peek()) {
                cryptStack.pop();
            } else {
                cryptStack.push(cryptogram.charAt(i));
            }
        }

        char[] chars = new char[cryptStack.size()];
        for(int i = chars.length-1; i >= 0; i--){
            chars[i] = cryptStack.pop();
        }

        return String.valueOf(chars);
    }

    public static String solution(String cryptogram) {
        return removeDuplicateCharacters(cryptogram);
    }
}
