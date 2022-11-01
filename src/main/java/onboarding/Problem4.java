package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {

        ArrayList<String> ArrayList = new ArrayList();
        String result = "";

        for (int i = 0; i < word.length(); i++) {

            // 대문자인 경우
            if ((int) word.charAt(i) >= 65 && (int) word.charAt(i) < 91) {
                result += (char) (155 - (int) word.charAt(i));
            }

            // 소문자인 경우
            else if ((int) word.charAt(i) >= 97 && (int) word.charAt(i) < 123) {
                result += (char) (219 - (int) word.charAt(i));
            }

            // 알파벳 외의 문자는 변환하지 않는다.
            else {
                result += (char) word.charAt(i);
            }
        }

        return result;
    }
}
