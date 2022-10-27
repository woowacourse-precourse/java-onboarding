package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static HashMap<Character, Character> fullmap () {
        HashMap<Character, Character> changeChar = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            changeChar.put((char) (65 + i), (char) (90 - i));
        }
        return changeChar;
    }

    public static char lowerChange (HashMap<Character, Character> map,char c) {
        char upChar = Character.toUpperCase(c);
        upChar = map.get(upChar);
        upChar = Character.toLowerCase(upChar);
        return upChar;
    }

    public static char upperChange (HashMap<Character, Character> map, char c) {
        return map.get(c);
    }

    public static char isChar (char c) {
        if (Character.isLowerCase(c)) return lowerChange(fullmap(),c);
        if (Character.isUpperCase(c)) return upperChange(fullmap(),c);
        return c;
    }

    public static String solution(String word) {
        String answer = "";
        for (char a : word.toCharArray()) {
            if (!Character.isLetter(a)) {
                answer += a;
                continue;
            }
            char k = isChar(a);
            answer += k;
        }
        return answer;
    }
}