package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String reversedWord = "";
        for(char ch : word.toCharArray()) {
            reversedWord += "" + reverseChar(ch);
        }
        return reversedWord;
    }

    public static char reverseChar(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) ('A' + 'Z' - ch);
        }else if (ch >= 'a' && ch <= 'z') {
            return (char) ('a' + 'z' - ch);
        }else{
            return ch;
        }
    }
}
