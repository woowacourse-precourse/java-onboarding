package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        while(checkDuplicate(cryptogram)) {
            cryptogram = deleteDuplicate(cryptogram);
        }
        String answer = cryptogram;
        return answer;
    }

    private static boolean checkDuplicate(String crypto) {
        for(int i = 0; i < crypto.length() - 1; i++) {
            if(crypto.charAt(i) == crypto.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static String deleteDuplicate(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        String deletedCryptogram = "";
        int flag = 0;
        for(int i = 0; i < cryptogram.length(); i++) {
            if(stack.isEmpty()==false && stack.peek().equals(cryptogram.charAt(i))) {
                stack.pop();
                flag = 1;
                if(i == cryptogram.length() - 1) continue;
                stack.push(cryptogram.charAt(i));
            } else {
                if(flag == 1) {
                    stack.pop();
                    flag = 0;
                }
                stack.push(cryptogram.charAt(i));
            }
        }
        for(char c: stack) {
            deletedCryptogram += c;
        }
        return deletedCryptogram;
    }
}
