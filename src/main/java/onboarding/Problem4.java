package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {

        HashMap<Character, Character> map = new HashMap<>();

        int A = 'A';
        int Z = 'Z';
        int a = 'a';
        int z = 'z';

        for (int i = 65; i < 91; i++) {
            char frCh = (char) i;
            int tmp = 65+(Z-i);
            char toCh = (char) tmp;
            map.put(frCh, toCh);
        }
        for (int i = 97; i < 123; i++) {
            char frCh = (char) i;
            int tmp = 97+(z-i);
            char toCh = (char) tmp;
            map.put(frCh, toCh);
        }
        String[] arrayWord = word.split("");
        ArrayList<String> arr = new ArrayList<>();
        Collections.addAll(arr, arrayWord);
        for (int i = 0; i < arrayWord.length; i++) {
            if (isAlpha(arrayWord[i].charAt(0))) {
                String str = String.valueOf(arrayWord[i]);
                arr.set(i, String.valueOf(map.get(str.charAt(0))));
            }
        }
        String answer = String.join("", arr);

        return answer;
    }

    public static boolean isAlpha(char ch) {
        int a = ch;
        if (a < 65 || a > 122) {
            return false;
        } else if (a>90 && a<97) {
            return false;
        }
        return true;
    }
}
