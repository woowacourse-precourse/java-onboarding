package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        List<Character> result = new ArrayList<>();
        ArrayList<Character> list = new ArrayList<>();
        char[] characterArray = word.toCharArray();
        for(char c : characterArray)
            list.add(c);

        for (char l : list) {
            if ((int) l < 91 && (int) l > 64) {
                char convert = (char) ((int) l + (25 - 2 * ((int) l - 65)));
                result.add(convert);
            } else if ((int) l < 123 && (int) l > 96) {
                char convert = (char) ((int) l - (25 - 2 * (122 - (int) l)));
                result.add(convert);
            } else {
                result.add(l);
            }
        }

        String answer = "";
        for (Character r : result) {
            answer += r;
        }
        return answer;
    }
}
