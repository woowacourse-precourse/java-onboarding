package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (char c : word.toCharArray()) {
            if (c == ' ') {
                answer += ' ';
            } else {
                if (Character.isUpperCase(c)) {
                    answer += (char) (155 - (int) c);
                    System.out.println((int)c);
                } else {
                    answer += (char) (219 - (int) c);
                }
            }
        }
        return answer;
    }
}
