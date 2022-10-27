package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        ArrayList<String> upperList = new ArrayList<>();
        ArrayList<String> lowerList = new ArrayList<>();

        int upperLastChar = 90;
        int lowerLastChar = 122;

        for (int i = 0; i < 26; i++) {
            upperList.add(String.valueOf((char) (upperLastChar - i)));
            lowerList.add(String.valueOf((char) (lowerLastChar - i)));
        }

        for (char c : word.toCharArray()) {
            int num = (int) c;

            // 공백
            if (num == 32) {
                answer += " ";
            }
            // 대문자
            else if (num < 91) {
                answer += upperList.get(num - 65);
            }
            // 소문자
            else if (num > 96) {
                answer += lowerList.get(num - 97);
            }

        }

        return answer;
    }
}
