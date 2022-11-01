package onboarding;

import java.util.ArrayList;
import java.util.Collections;

public class Problem4 {
    public static String solution(String word) {
        ArrayList<Character> alphabet = new ArrayList<>();
        ArrayList<Character> alphabetReverse = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        char[] wordList = word.toCharArray();

        for (int i = 0; i < 26; i++) {
            alphabet.add((char) ('a' + i));
            alphabetReverse.add((char) ('a' + i));
        }

        Collections.reverse(alphabetReverse);

        for (char i: wordList){
            if (Character.isUpperCase(i)){
                int idx = alphabet.indexOf(Character.toLowerCase(i));
                sb.append(Character.toUpperCase(alphabetReverse.get(idx)));
            } else if (Character.isLowerCase(i)){
                int idx = alphabet.indexOf(i);
                sb.append(alphabetReverse.get(idx));
            } else {
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
