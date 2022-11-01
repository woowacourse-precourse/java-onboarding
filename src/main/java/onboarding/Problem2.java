package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        String decipherdCryptogram = decipher(cryptogram);
        while (!cryptogram.equals(decipherdCryptogram)) {
            cryptogram = decipherdCryptogram;
            decipherdCryptogram = decipher(decipherdCryptogram);
        }

        answer = decipherdCryptogram;

        return answer;
    }

    public static String decipher(String cryptogram) {
        Stack<String> originCryptogramStack = new Stack<>();
        String newCrypogramString = "";

        String[] cryptogramArray = cryptogram.split("");

        for(int i = cryptogramArray.length - 1; i > -1; i--) {
            originCryptogramStack.push(cryptogramArray[i]);
        }

        if(originCryptogramStack.empty()) {
            return "";
        }

        String before = originCryptogramStack.pop();
        int count = 0;
        while (!originCryptogramStack.empty()) {
            String current = originCryptogramStack.pop();
            if(before.equals(current)) {
                count += 1;
            }
            else {
                if(count == 0) {
                    newCrypogramString += before;
                }

                if (originCryptogramStack.empty()) {
                    newCrypogramString += current;
                }

                before = current;
                count = 0;
            }
        }

        return newCrypogramString;
    }
}
