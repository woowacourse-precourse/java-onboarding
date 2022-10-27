package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        String[] upper = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                "T", "U", "V", "W", "X", "Y", "Z"};
        String[] lower = new String[upper.length];
        for(int i=0; i<upper.length; i++) {
            lower[i] = upper[i].toLowerCase();
        }
        ArrayList<String> upper_cases = new ArrayList<>(Arrays.asList(upper));
        ArrayList<String> lower_cases = new ArrayList<>(Arrays.asList(lower));
        ArrayList<String> cases;

        ArrayList<String> originWord = new ArrayList<>();
        for(int i=0; i<word.length(); i++)
            originWord.add(Character.toString(word.charAt(i)));

        for(int i=0; i<originWord.size(); i++) {

        }
        String answer = "";

        return answer;
    }
}
