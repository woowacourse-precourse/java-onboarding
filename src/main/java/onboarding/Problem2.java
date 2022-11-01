package onboarding;

import java.util.Stack;
public class Problem2 {

    public static String removeDuplication (String cryptogram) {
        Stack<Character> stringStack = new Stack<>();
        if (cryptogram.length() == 1) return cryptogram;

        if (cryptogram.length() == 2 && cryptogram.charAt(1) != cryptogram.charAt(0)) return cryptogram;

        for (int j = 0; j < cryptogram.length()-1; j++) {
            if (j == 0 && cryptogram.charAt(1) != cryptogram.charAt(0)){
                stringStack.push(cryptogram.charAt(j));
            }else if (cryptogram.charAt(j) != cryptogram.charAt(j+1)) {
                if (cryptogram.charAt(j-1) != cryptogram.charAt(j)) {
                    stringStack.push(cryptogram.charAt(j));
                }
                if (j == cryptogram.length()-2) {
                    stringStack.push(cryptogram.charAt(j+1));
                }
            }
        }
        String removedDuplicateString = "";
        for (char answerelEment : stringStack) {
            removedDuplicateString += answerelEment;
        }
        return removedDuplicateString;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}