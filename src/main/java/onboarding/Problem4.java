package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z')) {
                sb.append(ch);
                continue;
            }
            boolean flag = checkWord(ch);
            sb.append(convertWord(flag, ch));
        }

        answer = sb.toString();

        return answer;
    }

    // 현재 문자가 대문자인지 소문자인지 판별하는 메서드
    static boolean checkWord(char word) {
        if (Character.isLowerCase(word)) {
            return false;
        }
        return true;
    }

    // 문자를 반대로 변환하는 메서드
    static char convertWord(boolean flag, char word) {
        if (flag) {
            HashMap<Character, Character> upperMap = new HashMap<>();
            char upperStart = 'A';
            char upperEnd = 'Z';
            for (int i = 0; i < 26; i++) {
                upperMap.put(upperStart++, upperEnd--);
            }
            return upperMap.get(word);
        }

        HashMap<Character, Character> lowerMap = new HashMap<>();
        char lowerStart = 'a';
        char lowerEnd = 'z';
        for (int i = 0; i < 26; i++) {
            lowerMap.put(lowerStart++, lowerEnd--);
        }
        return lowerMap.get(word);
    }
}
