package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        List<String> lower_case = new ArrayList<>();
        List<String> upper_case = new ArrayList<>();

        for(int i = 0; i< 25; i++){
            lower_case.add(String.valueOf((char) (i + 97)));
            upper_case.add(String.valueOf((char) (i + 65)));
        }

        Collections.reverse(lower_case);
        Collections.reverse(upper_case);

        System.out.println(lower_case);
        System.out.println(upper_case);

        String[] word_list = word.split("");
        StringBuilder sb = new StringBuilder();

        for (String s : word_list) {
            char cha = s.charAt(0);
            if (cha >= 97 && cha <= 122) {
                sb.append(lower_case.get(cha - 98));
            } else if (cha >= 65 && cha <= 90) {
                sb.append(upper_case.get(cha - 66));
            } else
                sb.append(cha);
        }
        answer = sb.toString();
        return answer;
    }
}
