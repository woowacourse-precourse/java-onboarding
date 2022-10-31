package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();

        for(int i = 0; i < 26; i++) {
            // ASCII Code를 char로 형변환하여 배열에 담기
            upper.add((char)(65+i));
        }
        for(int i = 0; i < 26; i++) {
            // ASCII Code를 char로 형변환하여 배열에 담기
            lower.add((char)(97+i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                int index = upper.indexOf(word.charAt(i));
                answer += upper.get(25 - index);
            } else if (Character.isLowerCase(word.charAt(i))) {
                int index = lower.indexOf(word.charAt(i));
                answer += lower.get(25 - index);
            } else {
                answer += " ";
            }
        }
        return answer;
    }
}
