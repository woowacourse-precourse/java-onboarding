package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        char[] alpha = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R'
                , 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G'
                , 'F', 'E', 'D', 'C', 'B', 'A'};
        char[] alpha2 = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r'
                , 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g'
                , 'f', 'e', 'd', 'c', 'b', 'a'};
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(alpha2[c - 'a']);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(alpha[c - 'A']);
            } else {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }
}
