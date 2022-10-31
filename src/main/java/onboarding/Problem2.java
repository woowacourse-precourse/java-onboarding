package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";

        List<Character> cryplist = new ArrayList<Character>();
        char[] cryparray = cryptogram.toCharArray();
        for (char c : cryparray) {
            cryplist.add(c);
        }

        for (int i = 0; i < cryplist.size() - 1; i++) {
            if (cryplist.get(i) == cryplist.get(i + 1)) {
                cryplist.remove(i);
                cryplist.remove(i);
                i = -1;
            }
        }

        String temp_answer = "";
        for (char alpha : cryplist) {
            temp_answer += alpha;
        }

        answer = temp_answer;

        return answer;
    }
}
