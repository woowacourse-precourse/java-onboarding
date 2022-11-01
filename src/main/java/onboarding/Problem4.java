package onboarding;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder wordBuilder = new StringBuilder(word);

        // string 별로 변경
        for (int i = 0; i < word.length(); i++) {
            Character target = word.charAt(i);
            // 문자일 경우
            if (Character.isLetter(target)) {
                char change;
                // 대문자일 경우, 소문자로 변환 후 반대 알파벳 반환 -> 다시 대문자로 변경
                if (Character.isUpperCase(target)) {
                    change = Character.toUpperCase(charMap.get(Character.toLowerCase(target)));
                } else {
                    change = charMap.get(target);
                }
                wordBuilder.setCharAt(i, change);
            }
        }

        return wordBuilder.toString();
    }
    static HashMap<Character, Character> charMap = new HashMap<Character, Character>(){{
        put('a', 'z');
        put('b', 'y');
        put('c', 'x');
        put('d', 'w');
        put('e', 'v');
        put('f', 'u');
        put('g', 't');
        put('h', 's');
        put('i', 'r');
        put('j', 'q');
        put('k', 'p');
        put('l', 'o');
        put('m', 'n');
        put('n', 'm');
        put('o', 'l');
        put('p', 'k');
        put('q', 'j');
        put('r', 'i');
        put('s', 'h');
        put('t', 'g');
        put('u', 'f');
        put('v', 'e');
        put('w', 'd');
        put('x', 'c');
        put('y', 'b');
        put('z', 'a');
    }};
}
