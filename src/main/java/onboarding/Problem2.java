package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean done = false;
        List<String> list = new ArrayList(Arrays.asList(cryptogram.split("")));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(0) == list.get(1)) {
                list.remove(i + 1);
                list.remove(i);
            }
        }
        String answer = "answer";
        return answer;
    }
}
