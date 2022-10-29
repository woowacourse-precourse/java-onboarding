package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String alphabetSmall = "abcdefghijklmnopqrstuvwxyz";
        String alphabetBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < alphabetSmall.length(); i++) {
            map.put(alphabetSmall.charAt(i), alphabetSmall.charAt(alphabetSmall.length() - i - 1));
        }
        for (int i = 0; i < alphabetBig.length(); i++) {
            map.put(alphabetBig.charAt(i), alphabetBig.charAt(alphabetBig.length() - i - 1));
        }
        return reverseChar(word, map);
    }
    public static String reverseChar(String word, HashMap<Character, Character> map) {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                ret.append(map.get(c));
            } else {
                ret.append(c);
            }
        }
        return ret.toString();
    }
}
