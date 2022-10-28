package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static List<String> stringToArrayList(String cryptogram) {
        char [] cArray = cryptogram.toCharArray();
        List<String> convertedList = new ArrayList<>();
        for(char c : cArray) {
            convertedList.add(String.valueOf(c));
        }
        return convertedList;
    }

}
