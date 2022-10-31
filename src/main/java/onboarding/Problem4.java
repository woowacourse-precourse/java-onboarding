package onboarding;

import java.util.regex.Pattern;

public class Problem4 {
    public static String solution(String word) {
        String[] strArr = word.split("");
        String answer = "";
        for (String c: strArr) {
            answer += Pattern.matches("[a-zA-Z]", c) ? reverseAlpha(c) : c;
        }
        return answer;
    }
    static char reverseAlpha(String c) {
        String upperAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String revUpperAlpha = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lowerAlpha = "abcdefghijklnmopqrstuvwxyz";
        String revLowerAlpha = "zyxwvutsrqponmlkjihgfedcba";

        if (Character.isUpperCase(c.toCharArray()[0])) {
            int index = upperAlpha.indexOf(c);
            return revUpperAlpha.charAt(index);
        } else {
            int index = lowerAlpha.indexOf(c);
            return revLowerAlpha.charAt(index);
        }
    }
}
