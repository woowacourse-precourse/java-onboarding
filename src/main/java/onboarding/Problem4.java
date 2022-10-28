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

        String answer = "";
        for(int i=0; i<word.length(); i++) {
            char tmp = word.charAt(i);

            if(tmp >= 'A' && tmp <= 'Z')
                cases = upper_cases;
            else if(tmp >= 'a' && tmp <= 'z')
                cases = lower_cases;
            else {
                answer += Character.toString(tmp);
                continue;
            }

            String convert = Character.toString(tmp);
            int idx = cases.indexOf(convert);
            idx = 25 - idx;
            answer += cases.get(idx);
        }

        return answer;
    }
}
