package onboarding;

import java.util.ArrayList;
import java.util.List;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String[] splited = cryptogram.split("");
        List<String> arr = new ArrayList<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            arr.add(splited[i]);
        }

        int i = 0;

        while (arr.size() > 0 && i + 1 < arr.size()) {
            if (arr.get(i).equals(arr.get(i + 1))) {
                arr.remove(i);
                arr.remove(i);
                i = -1;
            }
            i++;
        }
        for (String str : arr) {
            answer += str;
        }

        return answer;
    }
}