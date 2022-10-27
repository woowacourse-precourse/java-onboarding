package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> duplicateChecker = new Stack<>();
        char[] cryptogramChars = cryptogram.toCharArray();

        for(int index=0; index<cryptogramChars.length; index++) {
            if (index==0 || duplicateChecker.empty()) {
                duplicateChecker.push(cryptogramChars[index]);
            }else if (duplicateChecker.peek() == cryptogramChars[index]) {
                duplicateChecker.pop();
            }else{
                duplicateChecker.push(cryptogramChars[index]);
            }
        }

        if(!duplicateChecker.empty()) {
            for(char cryptogramChar : duplicateChecker) {
                answer += "" + cryptogramChar;
            }
        }
        return answer;
    }
}
