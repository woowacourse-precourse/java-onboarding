package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        while (true) {
            StringBuilder newCryptogram = new StringBuilder();
            Stack<Character> temporaryStorage = new Stack<>();
            int count = 0;
            char removed = ' ';

            for (int j = 0; j < cryptogram.length(); j++) {
                char ch = cryptogram.charAt(j);
                if (removed == ch) {
                    removed = ' ';
                    continue;
                }
                if (temporaryStorage.isEmpty()) {
                    temporaryStorage.push(ch);
                } else {
                    if (temporaryStorage.peek() == ch) {
                        removed = temporaryStorage.pop();
                        count++;
                    } else {
                        temporaryStorage.push(ch);
                    }
                }
            }

            for (Character ch : temporaryStorage) {
                newCryptogram.append(ch);
            }

            temporaryStorage.clear();
            cryptogram = String.valueOf(newCryptogram);

            if (count == 0) {
                break;
            }

        }
        return cryptogram;
    }

}
