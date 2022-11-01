package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> newCryptogramChars = new Stack<>();
        char[] cryptogramChars = cryptogram.toCharArray();

        char poppedChar = '\0';

        for(int index=0; index<cryptogramChars.length; index++) {
            if (newCryptogramChars.empty()) {
                newCryptogramChars.push(cryptogramChars[index]);
                continue;
            }

            char prevChar = newCryptogramChars.peek();

            if (prevChar == cryptogramChars[index]) {
                poppedChar = newCryptogramChars.pop();
            }else if (poppedChar == cryptogramChars[index]) {
                continue;
            }else {
                newCryptogramChars.push(cryptogramChars[index]);
                poppedChar = '\0';
            }
        }

        for(char cryptogramChar : newCryptogramChars) {
            answer += "" + cryptogramChar;
        }
        return answer;
    }
}
