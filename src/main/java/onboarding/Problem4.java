package onboarding;

import java.util.ArrayList;
import java.util.Collections;


public class Problem4 {
    static ArrayList<Integer> InitAscii() {
        ArrayList<Integer> result = new ArrayList<>(
                Collections.nCopies(256, -1)
        );
        for (int i = 0; i < 26; i++) {
            result.set('A'+i, 'A'+25-i);
            result.set('a'+i, 'a'+25-i);
        }
        return result;
    }

    static String ReverseStr(String word) {
        String result = "";
        ArrayList<Integer> ascii_array = InitAscii();

        for(char c : word.toCharArray()) {
            if (ascii_array.get(c) != -1)
                result += Character.toString(ascii_array.get(c));
            else if (ascii_array.get(c) == -1)
                result += c;
        }
        return result;
    }

    public static String solution(String word) {
        String answer = ReverseStr(word);

        return answer;
    }
}
