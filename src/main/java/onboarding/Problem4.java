package onboarding;

import java.util.Scanner;

public class Problem4 {

    /*
    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }
*/
    public static String solution(String word) {
        String answer = "";

        char[] result = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (w != ' ') {
                if (w >= 'a' && w <= 'z') {
                    w = (char) (w + 25 - ((w - 'a') * 2));
                }

                if (w >= 'A' && w <= 'Z') {
                    w = (char) (w + 25 - ((w - 'A') * 2));
                }
            }
            result[i] = w;
        }
        answer = String.valueOf(result);
        return answer;
    }
}



