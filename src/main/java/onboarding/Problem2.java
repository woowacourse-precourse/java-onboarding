package onboarding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<String> crypto = Arrays.asList(cryptogram);
        iterateList(crypto);

        return answer;
    }

    private static void iterateList(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
                list.remove(i);
                i--;
            }
        }
    }
}
