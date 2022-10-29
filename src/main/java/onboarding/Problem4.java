package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static List<String> stringToList(String word) {
        char [] cArray = word.toCharArray();
        List<String> convertedList = new ArrayList<>();
        for(char c : cArray) {
            convertedList.add(String.valueOf(c));
        }
        return convertedList;
    }
}
