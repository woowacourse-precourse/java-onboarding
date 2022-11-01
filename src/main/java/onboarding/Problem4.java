package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        int A = 'A';
        int Z = 'Z';
        int a = 'a';
        int z = 'z';
        List<String> num_list = new ArrayList<>();

        for(int i = 0; i < word.length(); i++) {
            int charNum = word.charAt(i);
            if(charNum > a && charNum < z) {
                charNum = z - (charNum - a);
                num_list.add(Character.toString(charNum));
            } else if (charNum > A && charNum < Z) {
                charNum = Z - (charNum - A);
                num_list.add(Character.toString(charNum));
            } else {
                num_list.add(" ");
            }
        }

        answer = String.join("", num_list);

        return answer;
    }
}
