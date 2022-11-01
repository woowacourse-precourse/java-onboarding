package onboarding;

import ExceptionValidation.P2ExceptionValidation;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

    public static String solution(String cryptogram) {

        if(!(P2ExceptionValidation.p2ExceptionValidation(cryptogram))){
            return "";
        }
        String decrypedString = findDecryptedString(cryptogram);

        return decrypedString;
    }

    public static String findDecryptedString(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        int duplicatedCount = 0;

        for (int i = 0; i < cryptogram.length(); i++) {
            String s = cryptogram.substring(i,i+1);

            Character current = s.charAt(0);

            if (stack.empty()) {
                stack.push(current);
            }
            else {
                if (stack.peek() != current) {
                    for(int j = 0 ; j < duplicatedCount ; j++){
                        if(!stack.isEmpty()){
                            stack.pop();
                        }
                    }
                    duplicatedCount = 0;
                }
                if (!stack.isEmpty() && stack.peek() == current) {
                    if (duplicatedCount == 0) {
                        duplicatedCount += 1;
                    }
                    duplicatedCount += 1;
                }
                stack.push(s.charAt(0));
            }
        }
        for(int i = 0 ; i < duplicatedCount ; i++){
            if(!stack.isEmpty()) {
                stack.pop();
            }
        }


        return stack.stream().map((v) -> v.toString()).collect(Collectors.joining(""));
    }
}