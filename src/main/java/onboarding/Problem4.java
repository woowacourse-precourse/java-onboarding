package onboarding;

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

        




        String answer = "";
        return answer;
    }

    public static boolean isAlpha(char ch) {
        return true;
    }
}
